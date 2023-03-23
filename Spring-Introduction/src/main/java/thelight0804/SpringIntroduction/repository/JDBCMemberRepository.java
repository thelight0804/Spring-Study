package thelight0804.SpringIntroduction.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import thelight0804.SpringIntroduction.domain.Member;

public class JDBCMemberRepository implements MemberRepository {

  private final DataSource dataSource;

  //DataBase 주입
  public JDBCMemberRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public Member save(Member member) {
    String sql = "insert into member(name) values(?)"; //쿼리 명령어

    Connection conn = null; //Connection
    PreparedStatement pstmt = null; //SQL 명령어를 동적으로 변경
    ResultSet rs = null; //DB 처리 결과에 사용되는 값

    try {
      conn = getConnection(); //DB Connection 받기
      pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      //prepareStatement(SQL, primary key)


      pstmt.setString(1, member.getName());
      //insert into member(name) values(1)으로 변경된다

      pstmt.executeUpdate(); //쿼리 전송(업데이트)
      rs = pstmt.getGeneratedKeys();
      //getGeneratedKeys를 ResultSet에 저장한다

      if (rs.next()) { //업데이트가 성공했을 때 성공
        member.setId(rs.getLong(1));
      } else { //실패했을 때
        throw new SQLException("id 조회 실패");
      }
      return member;
    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs); //자원 반환
    }
  }

  @Override
  public Optional<Member> findById(Long id) {
    String sql = "select * from member where id = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setLong(1, id);

      rs = pstmt.executeQuery();
      //업데이트가 아니라 execute로 실행(조회)한다

      if (rs.next()) { //값이 있으면 반환한다
        Member member = new Member(); //member 객체 생성
        member.setId(rs.getLong("id")); //객체 데이터 추가
        member.setName(rs.getString("name"));
        return Optional.of(member); //객체 반환
      } else {
        return Optional.empty();
      }
    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs); //자원 반환
    }
  }

  @Override
  public List<Member> findAll() {
    String sql = "select * from member";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      List<Member> members = new ArrayList<>();
      while (rs.next()) { //ArrayList에 값 저장
        Member member = new Member();
        member.setId(rs.getLong("id"));
        member.setName(rs.getString("name"));
        members.add(member);
      }

      return members; //값 반환
    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs); //자원 반환
    }
  }

  @Override
  public Optional<Member> findByName(String name) {
    String sql = "select * from member where name = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
      conn = getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        Member member = new Member();
        member.setId(rs.getLong("id"));
        member.setName(rs.getString("name"));
        return Optional.of(member);
      }
      return Optional.empty();
    } catch (Exception e) {
      throw new IllegalStateException(e);
    } finally {
      close(conn, pstmt, rs); //자원 반환
    }
  }

  //DataSourceUtils 사용하여 가져오기
  private Connection getConnection() {
    return DataSourceUtils.getConnection(dataSource);
  }

  /**
   * 자원 반환
   * @param conn
   * @param pstmt
   * @param rs
   */
  private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (pstmt != null) {
        pstmt.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if (conn != null) {
        close(conn);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  ////DataSourceUtils 사용하여 닫기
  private void close(Connection conn) throws SQLException {
    DataSourceUtils.releaseConnection(conn, dataSource);
  }
}
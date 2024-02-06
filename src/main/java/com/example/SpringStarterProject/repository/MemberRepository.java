package com.example.SpringStarterProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringStarterProject.model.Member;

/**
 * MemberRepository
 */
@Repository
public class MemberRepository {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  private static final String SEARCH_SQL = """
      SELECT 
        name
      FROM
        members
      WHERE
        name LIKE '%'||:name||'%'
      """;

  private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
    Member member = new Member();
    member.setName(rs.getString("name"));
    return member;
  };

  public List<Member> search(String name) {
    MapSqlParameterSource param = new MapSqlParameterSource().addValue("name", name);
    List<Member> memberList = jdbcTemplate.query(SEARCH_SQL, param, MEMBER_ROW_MAPPER);
    return memberList;
  }
}

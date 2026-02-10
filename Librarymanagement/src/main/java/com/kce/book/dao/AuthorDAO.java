package com.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kce.book.bean.AuthorBean;
import com.kce.book.util.DBUtil;

public class AuthorDAO {

    public boolean addAuthor(AuthorBean author) {
        String query ="INSERT INTO AUTHOR_TBL (AUTHOR_CODE, AUTHOR_NAME, CONTACT_NO) VALUES (101, 'Ibrahim', 9876543210)";

        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, author.getAuthorcode());
            ps.setString(2, author.getAuthorName());
            ps.setLong(3, author.getContactNumber());

            int rows = ps.executeUpdate();
            return rows > 0; 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public AuthorBean getAuthorByCode(String authorName) {
        AuthorBean author = null;
        String query = "SELECT * FROM AUTHOR_TBL WHERE AUTHOR_CODE = ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, authorName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                author = new AuthorBean();
                author.setAuthorcode(rs.getInt("AUTHOR_CODE"));
                author.setAuthorName(rs.getString("AUTHOR_NAME"));
                author.setContactNumber(rs.getLong("CONTACT_NO"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }

    public AuthorBean getAuthorByName(String authorName) {
        AuthorBean author = null;
        String query = "SELECT * FROM AUTHOR_TBL WHERE AUTHOR_NAME = ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, authorName); // Use setString, not setLong
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                author = new AuthorBean();
                author.setAuthorcode(rs.getInt("AUTHOR_CODE"));
                author.setAuthorName(rs.getString("AUTHOR_NAME"));
                author.setContactNumber(rs.getLong("CONTACT_NO"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }
}
package com.exam.ab.controller;

import com.exam.ab.model.dbConnection;
import com.exam.ab.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.*;
import java.util.*;

    @Controller
    public class MemberController{

        ArrayList<Member>medlemmer = new ArrayList<Member>();


        @GetMapping("/addMemberSite")
        public String addMemberSite(Model model) {

            model.addAttribute("Member",new Member());
            return "addMemberSite";
        }

        @GetMapping("/vismedlemmer")
        public String vismedlemmer(Model model){
            model.addAttribute("medlemmer", showMember());
            return "vismedlemmer";
        }

        @PostMapping("/addMemberSite")
        public String Medlem(@ModelAttribute Member member, BindingResult bindingResult) {

            addMember(member);
            return "redirect:/confirmMember";
        }

        private void addMember(Member member) {
            dbConnection db = dbConnection.getInstance();
            Connection con = db.createConnection();
            Statement s = null;
            PreparedStatement preparedStatement1 = null;
            try {
                preparedStatement1 = con.prepareStatement("INSERT INTO member(member_firstname, member_lastname, member_cpr, member_adress, zip_code, phone_number, email_adress) VALUES(?,?,?,?,?,?,?)");
                preparedStatement1.setString(1, member.getFirstName());
                preparedStatement1.setString(2, member.getLastName());
                preparedStatement1.setString(3, member.getCPR());
                preparedStatement1.setString(4, member.getAdress());
                preparedStatement1.setInt(5, member.getZipcode());
                preparedStatement1.setInt(6, member.getPhone());
                preparedStatement1.setString(7, member.getEmail());
                preparedStatement1.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public ArrayList<Member> showMember() {
            ArrayList<Member> memberList = new ArrayList<>();

            dbConnection db = dbConnection.getInstance();
            Connection con = db.createConnection();
            Statement s = null;

            try {
                ResultSet resultSet = s.executeQuery("SELECT * FROM member INNER JOIN zipcode ON member.zip_code = zipcode.zipcode_zipcode");
                while (resultSet.next()) {
                    try {
                        Member member = new Member();
                        member.setFirstName(resultSet.getString("member_firstname"));
                        member.setLastName(resultSet.getString("member_lastname"));
                        member.setCPR(resultSet.getString("member_cpr"));
                        member.setAdress(resultSet.getString("member_adress"));
                        member.setZipcode(resultSet.getInt("zip_code"));
                        member.setPhone(resultSet.getInt("phone_number"));
                        member.setEmail(resultSet.getString("email_adress"));

                        memberList.add(member);

                    } catch (SQLException e) {
                        e.printStackTrace();

                    }
                }
            }

            catch (SQLException e) {
                e.printStackTrace();
            }


            return memberList;

    }

    }


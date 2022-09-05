
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TermProjectMainMadsix {
    public static void main(String[] args) {
        // [Process 1.] MySQL 접속 -> Connect to Database
        // (Host,Username 확인 - 그리고 default schema로 'world' 선택)
        // Referenced Libraries 첨부 (From the path below)
        // C:\Program Files (x86)\MySQL\Connector J 8.0
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/miniproject_madsix"; // "jdbc:mysql: 'Connect to Database 내 Connection Method'
        String QUERY = " "; // QUERY 정의 

        Scanner sc = new Scanner(System.in);


        System.out.print("선택>> "); // 첫 SCREEN에 "선택>> " Pop-up
        
        TermProjectPollsMadsix polls = new TermProjectPollsMadsix();
        int val = polls.PollFunction();

        TeamProjectStatisticsMadsix statics = new TeamProjectStatisticsMadsix();
        val = statics.StatisticFunction();
       
    
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Red Underline -> Quick Fix로 'Import Connection' (java.sql) 'Import
            // DriverManager' (java.sql)
            // getConnection () Error pop-up => Quick fix with Surrounding Try and Catch
             
//[question1]
            Statement stmt1 = conn.createStatement(); // == MySQL 내 Query1
         
            ResultSet rs1 = stmt1.executeQuery(QUERY);
            // Red Underline -> Quick Fix로 'Import ResultSet'(java.sql)

            while (rs1.next()) { 
                // Retrieve by column name
                System.out.print("ANSWER_KEY: " + rs1.getInt("ANSWER_KEY"));
                System.out.print(", ANSWER: " + rs1.getString("ANSWER"));

//[questions]
            Statement stmt2 = conn.createStatement(); // == MySQL 내 Query1
                
            ResultSet rs2 = stmt2.executeQuery(QUERY);
                // Red Underline -> Quick Fix로 'Import ResultSet'(java.sql)
                // Line-by-line computer-based read를 가능하게 함
            while (rs2.next()) { // 데이터의 양을 모름--> while, 알면 for문으로 접근
                    // Retrieve by column name
                    System.out.print("ID: " + rs1.getInt("ANSWER_KEY"));
                    System.out.print(", question1: " + rs2.getInt("question1"));
                    System.out.print(", question2: " + rs2.getInt("question2"));
                    System.out.print(", question3: " + rs2.getInt("question3"));
                    System.out.print(", question4: " + rs2.getInt("question4"));
            }
//[surveyee]
            Statement stmt3 = conn.createStatement(); // == MySQL 내 Query1
                
            ResultSet rs3 = stmt3.executeQuery(QUERY);
                // Red Underline -> Quick Fix로 'Import ResultSet'(java.sql)
                // Line-by-line computer-based read를 가능하게 함
            while (rs3.next()) { // 데이터의 양을 모름--> while, 알면 for문으로 접근
                // Retrieve by column name
                    System.out.print("ID: " + rs3.getInt("ID"));
                    System.out.print(", NAME: " + rs3.getString("NAME"));
            }
        }      

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    

        // Process 4. IF succeeded,
        // ID, NAME, CountryCode, District, Population Column 확인
        // Process 5. Column 내 dataset 확인

        return;
        }
    }

    

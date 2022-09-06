import java.sql.*;
import java.util.Scanner;

public class TermProjectPollsMadsix {
    Scanner scan = new Scanner(System.in);

    public int id;
    public String inputName;
    public String ans;
    public int ans1;
    public int ans2;
    public int ans3;
    public int ans4;

    // 설문 번호 쿼리 받기
    public String getNumberQuery() {
        String query = "SELECT MAX(ID) AS max_num FROM surveyee";
        return query;
    }
    
    // 설문 번호 받기
    public void getNumber(ResultSet rs) {
        try {
            while (rs.next()) {
                id = rs.getInt("max_num") + 1;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ;
    }
    
    // 이름 받기
    public void getName() {
        System.out.print("이름을 입력해주세요. : ");
        inputName = scan.nextLine();
        System.out.println();
    }
    
    // 설문 문항 시작
    public void startPoll(Statement stmt) {
        boolean run = true;
        while (run) {
            run = true;
            System.out.println("설문을 시작합니다.\n");
            System.out.println("-----------------------------------------------------------------------------");
            run = question1();
            System.out.println("\n-----------------------------------------------------------------------------");
            if (run == false) {
                System.out.println("\n현재 작성중인 설문을 취소합니다.");
                break;
            }
            System.out.println();
            run = question2();
            System.out.println("\n-----------------------------------------------------------------------------");
            if (run == false) {
                System.out.println("\n현재 작성중인 설문을 취소합니다.");
                break;
            }
            System.out.println();
            run = question3();
            System.out.println("\n-----------------------------------------------------------------------------");
            if (run == false) {
                System.out.println("\n현재 작성중인 설문을 취소합니다.");
                break;
            }
            System.out.println();
            run = question4();
            System.out.println("\n-----------------------------------------------------------------------------");
            if (run == false) {
                System.out.println("\n현재 작성중인 설문을 취소합니다.");
                break;
            }
            int val;
            try {
                val = stmt.executeUpdate(getInsertSurveyeeQuery());
                val = stmt.executeUpdate(getInsertQuestionsQuery());
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            System.out.println();
            break;
        }

    }
    
    public boolean question1() { // 1번 문항

        System.out.println("설문을 종료하고 싶으면 'Q'를 입력하세요.\n");
        System.out.println("1. 백화점의 입지는 접근하기에 용이한가?");
        System.out.print("1. 매우 그렇다\t");
        System.out.print("2. 그렇다\t");
        System.out.print("3. 보통\t");
        System.out.print("4. 그렇지 않다\t");
        System.out.println("5. 매우 그렇지 않다.\t");
        System.out.print("입력 : ");
        ans = scan.nextLine();
        if (ans.equals("q") || ans.equals("Q")) {
            return false;
        }
        else {
            ans1 = Integer.parseInt(ans);
            return true;
        }
    }

    public boolean question2() { // 2번 문항
        System.out.println("설문을 종료하고 싶으면 'Q'를 입력하세요.\n");
        System.out.println("2. 백화점의 고객 응대는 만족스러운가?");
        System.out.print("1. 매우 그렇다\t");
        System.out.print("2. 그렇다\t");
        System.out.print("3. 보통\t");
        System.out.print("4. 그렇지 않다\t");
        System.out.println("5. 매우 그렇지 않다.\t");
        System.out.print("입력 : ");
        ans = scan.nextLine();
        if (ans.equals("q") || ans.equals("Q")) {
            return false;
        }
        else {
            ans2 = Integer.parseInt(ans);
            return true;
        }
    }

    public boolean question3() { // 3번 문항
        System.out.println("설문을 종료하고 싶으면 'Q'를 입력하세요.\n");
        System.out.println("3. 백화점의 편의시설은 잘 마련되어 있는가?");
        System.out.print("1. 매우 그렇다\t");
        System.out.print("2. 그렇다\t");
        System.out.print("3. 보통\t");
        System.out.print("4. 그렇지 않다\t");
        System.out.println("5. 매우 그렇지 않다.\t");
        System.out.print("입력 : ");
        ans = scan.nextLine();
        if (ans.equals("q") || ans.equals("Q")) {
            return false;
        }
        else {
            ans3 = Integer.parseInt(ans);
            return true;
        }
    }
    
    public boolean question4() { // 4번 문항
        System.out.println("설문을 종료하고 싶으면 'Q'를 입력하세요.\n");
        System.out.println("4. 백화점 내 입점 매장은 다양한가?");
        System.out.print("1. 매우 그렇다\t");
        System.out.print("2. 그렇다\t");
        System.out.print("3. 보통\t");
        System.out.print("4. 그렇지 않다\t");
        System.out.println("5. 매우 그렇지 않다.\t");
        System.out.print("입력 : ");
        ans = scan.nextLine();
        if (ans.equals("q") || ans.equals("Q")) {
            return false;
        }
        else {
            ans4 = Integer.parseInt(ans);
            return true;
        }
    }

    // 설문자 정보 입력할 쿼리
    public String getInsertSurveyeeQuery() {
        String query = "INSERT INTO surveyee (id, name) VALUES ("+id+", \""+inputName+"\")";
        return query;
    }
    // 설문 내용 입력할 쿼리
    public String getInsertQuestionsQuery() {
        String query = "INSERT INTO questions (id, question1, question2, question3, question4) " +
                        "VALUES ("+id+", "+ans1+", "+ans2+", "+ans3+", "+ans4+")";
        System.out.println("설문이 정상적으로 등록되었습니다.\n");
        System.out.println("고객님의 설문번호는 " + id + "번입니다.\n설문 수정 시 필요하니 기억해주세요!");
        return query;
    }

    // 설문 수정
    public void editPolls() {
        
        return ;
    }
}
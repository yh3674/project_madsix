import java.sql.*;

public class TermProjectStatisticsMadsix {

    int total;

    // 통계 시작하기
    public void startStatistics() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("원하시는 통계 메뉴를 선택해주세요.\n");
        System.out.println("1. 설문자별 통계 출력");
        System.out.println("2. 문항별 통계 출력");
        System.out.println("3. 문항별 통계 시각화");
        System.out.println("4. 이전 메뉴로 돌아가기");
        System.out.print("선택 : ");
        return ;
    }
    
    // 문항 리스트
    public void questionList() {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("통계 자료를 확인할 문항을 선택해주세요.\n");
        System.out.println("1. 백화점의 입지는 접근하기에 용이한가?");
        System.out.println("2. 백화점의 고객 응대는 만족스러운가?");
        System.out.println("3. 백화점의 편의시설은 잘 마련되어 있는가?");
        System.out.println("4. 백화점 내 입점 매장은 다양한가?");
        System.out.println("5. 뒤로 가기");
        return ;
    }
    
    // 설문자별 통계 쿼리 받기
    public String getSurveyeeQuery() {
        String query = "SELECT surveyee.ID, surveyee.Name, a1.answer as question1, a2.answer as question2, a3.answer as question3, a4.answer as question4 " +
        "FROM (((((questions " +
        "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
        "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
        "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
        "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
        "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4)";
        return query;
    }
    
    // 설문자별 통계 출력
    public void pollsSurveyee (ResultSet rs) {

        try {
            System.out.println("설문자별 통계입니다.\n");
            System.out.println("\t\t\t\t백화점의 입지는 접근하기에 용이한가?\t\t백화점의 고객 응대는 만족스러운가?\t\t백화점의 편의시설은 잘 마련되어 있는가?\t\t백화점 내 입점 매장은 다양한가?\n\n");
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("설문 번호 " + rs.getInt("surveyee.ID")+", ");
                System.out.print(" 이름: " + rs.getString("surveyee.Name")+ "\t");
                System.out.print(String.format("%-45s", rs.getString("question1")));
                System.out.print(String.format("%-45s", rs.getString("question2")));
                System.out.print(String.format("%-45s", rs.getString("question3")));
                System.out.print(String.format("%-45s", rs.getString("question4")));
                System.out.println("\n");
             }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ;
    }
    
    // 문항별 통계 쿼리 받기
    public String getQuestion1Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "RIGHT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question1 " +
                        "GROUP BY Q1.question1 " +
                        "ORDER BY answers.Answer_key";
        System.out.println("1. 백화점의 입지는 접근하기에 용이한가? 통계입니다.");
        return query;
    }
    public String getQuestion2Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "RIGHT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question2 " +
                        "GROUP BY Q1.question2 " +
                        "ORDER BY answers.Answer_key";
        System.out.println("2. 백화점의 고객 응대는 만족스러운가? 통계입니다.");
        return query;
    }
    public String getQuestion3Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "RIGHT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question3 " +
                        "GROUP BY Q1.question3 " +
                        "ORDER BY answers.Answer_key";
        System.out.println("3. 백화점의 편의시설은 잘 마련되어 있는가? 통계입니다.");
        return query;
    }
    public String getQuestion4Query() {
        String query = "SELECT answer, Count(ID) " +
                        "FROM answers " + 
                        "RIGHT JOIN ( " +
                            "SELECT surveyee.ID, surveyee.Name, a1.answer_key as question1, a2.answer_key as question2, a3.answer_key as question3, a4.answer_key as question4 " +
                            "FROM (((((questions " +
                            "INNER JOIN surveyee ON questions.ID = surveyee.ID) " +
                            "INNER JOIN answers AS a1 ON a1.ANSWER_KEY = questions.QUESTION1) " +
                            "INNER JOIN answers AS a2 ON a2.ANSWER_KEY = questions.QUESTION2) " +
                            "INNER JOIN answers AS a3 ON a3.ANSWER_KEY = questions.QUESTION3) " +
                            "INNER JOIN answers AS a4 ON a4.ANSWER_KEY = questions.QUESTION4) " +
                            ") AS Q1 " +
                        "ON answers.answer_key = Q1.question4 " +
                        "GROUP BY Q1.question4 " +
                        "ORDER BY answers.Answer_key";
        System.out.println("4. 백화점 내 입점 매장은 다양한가? 통계입니다.");
        return query;
    }
   
    // 문항별 통계
    public void pollsQuestion (ResultSet rs) {

        try {
            System.out.println();
            while (rs.next()) {
                // Retrieve by column name
                System.out.print(rs.getString("answer") + " : ");
                System.out.println(rs.getInt("COUNT(ID)") + "개");
             }
             System.out.println();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ;
    }

    // 전체 설문 인원 받는 쿼리
    public String getTotalNumber() {
        String query = "SELECT COUNT(ID) FROM questions";
        return query;
    }

    // 전체 설문수 입력 쿼리
    public void totalNumber(ResultSet rs) {
        try {
            System.out.println();
            while (rs.next()) {
                total = rs.getInt("COUNT(ID)");
            }
             System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 응답 그래프 그리기
    public void statisticsGraph(ResultSet rs) {

        try {
            System.out.println();
            String bar = ":";
            while (rs.next()) {
                System.out.printf(" %s\t\t", (rs.getString("answer")).trim());
                int ans1 = rs.getInt("COUNT(ID)");
                double percentage = (double) ans1 / total * 100;
                for(int i = 0; i <= percentage; i++) {
                    System.out.print("|");
                }
                System.out.println(String.format(" %.2f", percentage) + " %");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }


}
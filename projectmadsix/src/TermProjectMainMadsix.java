import java.sql.*;
import java.util.Scanner;

public class TermProjectMainMadsix {

    static final String DB_URL = "jdbc:mysql://localhost/miniproject_madsix";
    static final String USER = "root";
    static final String PASS = "tbrs00002b";
    public static boolean poll = true; // 전체 설문조사 컨트롤러

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TermProjectStatisticsMadsix stats = new TermProjectStatisticsMadsix();
        TermProjectPollsMadsix polls = new TermProjectPollsMadsix();
      
        
        try (
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            )
        {          
            while(poll) {
                ResultSet rs;
                System.out.println("메뉴를 선택해주세요.\n");
                System.out.println("설문: P     통계: S     종료: Q\n");
                System.out.print("선택 : ");
                String choice = scan.nextLine();
                System.out.println();
    
                switch (choice) {
                    case "p" :
                    case "P" :
                        rs = stmt.executeQuery(polls.getNumberQuery());
                        polls.getNumber(rs);
                        polls.getName();
                        polls.startPoll();
                        int val = stmt.executeUpdate(polls.getInsertSurveyeeQuery());
                        val = stmt.executeUpdate(polls.getInsertQuestionsQuery());
                        break;
                    case "s" : // 통계 메뉴 시작
                    case "S" : // 통계 메뉴 시작
                        boolean sts = true;
                        while (sts) {
                            stats.startStatistics();
                            int menu = Integer.parseInt(scan.nextLine());
                            System.out.println();
                                switch (menu) {
                                    case 1 : // 설문자별 통계 확인하기
                                        rs = stmt.executeQuery(stats.getSurveyeeQuery());
                                        stats.pollsSurveyee(rs);
                                        break;
                                    case 2 : // 문항별 통계 출력하기
                                        stats.questionList();
                                        System.out.print("선택 : ");
                                        int opt = Integer.parseInt(scan.nextLine());
                                        System.out.println();
                                        switch (opt) {
                                            case 1 : rs = stmt.executeQuery(stats.getQuestion1Query()); // 1번 문항
                                                    stats.pollsQuestion(rs);
                                                    break;
                                            case 2 : rs = stmt.executeQuery(stats.getQuestion2Query()); // 2번 문항
                                                    stats.pollsQuestion(rs);
                                                    break;
                                            case 3 : rs = stmt.executeQuery(stats.getQuestion3Query()); // 3번 문항
                                                    stats.pollsQuestion(rs);
                                                    break;
                                            case 4 : rs = stmt.executeQuery(stats.getQuestion4Query()); // 4번 문항
                                                    stats.pollsQuestion(rs);
                                                    break;
                                            case 5 :
                                                System.out.println("이전 메뉴로 돌아갑니다.\n");
                                                break;
                                        }
                                        break;
                                    case 3 : // 그래프로 시각화하기
    
                                        break;
                                    case 4 : // 이전 메뉴로 돌아가기
                                        System.out.println("이전 메뉴로 돌아갑니다.\n");
                                        sts = false;
                                }
                        }
                        break;
                    case "q" : // 설문 종료
                    case "Q" : // 설문 종료
                        System.out.println("설문을 종료합니다.");
                        poll = false;
    
                }
                System.out.println();
            }

		} catch (SQLException e) { // SQL 예외처리
			e.printStackTrace();
		}
      
   }
}
    





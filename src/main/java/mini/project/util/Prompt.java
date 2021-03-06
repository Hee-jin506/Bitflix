package mini.project.util;

import java.sql.Date;
import java.util.Scanner;
import mini.project.domain.Genre;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);

  // 다른 패키지에서 메서드를 호출할 수 있도록 사용 범위를 public 으로 공개한다.
  public static String inputString(String title) {
    System.out.print(title);
    return keyboardScan.nextLine();
  }

  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  public static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  public static Genre inputGenre(String title) {
    Genre genre;
    while (true) {
      try {
        genre = Genre.valueOf(inputString(title));
        break;
      } catch (Exception e) {
        System.out.println("다시 입력해주세요.");
      }
    }
    return genre;
  }

  // 프롬프트의 사용이 모두 끝났으면
  // ㄴ어라ㅣ어나ㅣ러ㅐㄷ겨ㅐㅓㄴㅇ라ㅣㅡㄹ이ㅏㄴ거ㅏㅣㅓ히ㅏㄴㅈ을,ㅣㄴ으라ㅣ뎌ㅗ갸ㅐ뎌개ㅏ워ㅏㅣㄹ누ㅡ,ㅡㄹ,기마현우르ㅡㅈ,ㅡ,ㅡㅏㄴㅇ
  // 이 메서드를 호출하여 System.in 입력 스트림 자원을 해제하도록 한다.
  public static void close() {
    keyboardScan.close();
  }
}

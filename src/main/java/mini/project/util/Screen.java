package mini.project.util;

import mini.project.domain.Genre;
import mini.project.domain.Movie;

public class Screen {

  public static void beforeSignUp() {
    logo("BITFLIX");

  }

  public static void afterSignUp() {

  }

  public static void viewMovies(Movie[] movies) {

    for (int i = 0; i < movies.length; i++) {
      // if (i % 10 == 0 && i != 0) {
      // if (!Prompt.inputString("더 보시겠습니까?(y/N)").equalsIgnoreCase("y")) {
      // break;
      // }
      // }
      if (i == 10) {
        break;
      }
      System.out.printf("%10s\t%d. %s\n", "", i + 1, movies[i].getTitle());
    }
    System.out.println();
  }

  public static void menu() {
    System.out.printf("*************************************************************\n", "");
    System.out.printf("*%59s*\n", "");
    System.out.printf("*-----------------!!      %-10s      !!----------------*\n");
    System.out.printf("*%59s*\n", "");
    System.out.printf("*************************************************************\n", "");
  }

  public static void logo(String logo) {
    System.out.printf("*************************************************************\n", "");
    System.out.printf("*%59s*\n", "");
    System.out.printf("*-----------------!!      %-10s      !!----------------*\n", logo);
    System.out.printf("*%59s*\n", "");
    System.out.printf("*************************************************************\n", "");
    System.out.println();
  }

  public static void bitflixLogo() {
    System.out.println("  ____    _____   _______   ______   _        _____  __   __");
    System.out.println(" |  _ \\  |_   _| |__   __| |  ____| | |      |_   _| \\ \\ / /");
    System.out.println(" | |_) |   | |      | |    | |__    | |        | |    \\ V /");
    System.out.println(" |  _ <    | |      | |    |  __|   | |        | |     > < ");
    System.out.println(" | |_) |  _| |_     | |    | |      | |____   _| |_   / . \\ ");
    System.out.println(" |____/  |_____|    |_|    |_|      |______| |_____| /_/ \\_\\");
    System.out.println();
  }


  public static void getHorrorScreen() throws InterruptedException {
    System.out.println("                       ---                ");
    Thread.sleep(300);
    System.out.println("                    -        --                 ");
    Thread.sleep(300);
    System.out.println("                --( /     \\ )XXXXXXXXXXXXX           ");
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
    Thread.sleep(300);
    System.out.println();
  }

  public static void getFamilyScreen() throws InterruptedException {
    System.out.println("                           ,-''`-.");
    Thread.sleep(300);
    System.out.println("                           /       `");
    Thread.sleep(300);
    System.out.println("                     __,-'/       _.  `--.");
    Thread.sleep(300);
    System.out.println("                   ,'   ,'      ,'  ,--.  )");
    Thread.sleep(300);
    System.out.println("                 ,'   ,'       /  ,(  ,/)/");
    Thread.sleep(300);
    System.out.println("                /           ,',;-,-),;('");
    Thread.sleep(300);
    System.out.println("               /      __.-',--'  ,,|/  `-.__");
    Thread.sleep(300);
    System.out.println("              /  ,      ),',;;  (O)(        `--.");
    Thread.sleep(300);
    System.out.println("    ,.----.__/_,'      // /O)\\  `.  \\--'`-.     )");
    Thread.sleep(300);
    System.out.println("  ,' __         _,.-'  ,/,-     c.' /  `.  `  ,/   .-.");
    Thread.sleep(300);
    System.out.println(" / ,'         ,'  _,-' (,,-\\  -==*'/     )   (      ) \\");
    Thread.sleep(300);
    System.out.println("','      ,  ,'  ,'     ,'--`\\-.___/.    ,   ( `-..-'   ");
    Thread.sleep(300);
    System.out.println("|      ,'   |          ``'\\  \\ ,    `.       `.      ,\'");
    Thread.sleep(300);
    System.out.println("| /   /      \\        ,' \\ )- )      |            --' )");
    Thread.sleep(300);
    System.out.println(" ||  | .      .      (   //  /       |   ---._      ,'");
    Thread.sleep(300);
    System.out.println("  `. '. `-.          |  //  |        |   ,--' `-.-.'");
    Thread.sleep(300);
    System.out.println("    `--:._ `-.._     | //   |     Y  | ,'");
    Thread.sleep(300);
    System.out.println("                `'-- )'/    |   ,'  /-'");
  }

  public static void getRomanceScreen() {
    System.out.println(".,,,,,,,,,,.");
    System.out.println(",;;;;;;;;;;;;;;,");
    System.out.println(",;;;;;;;;;;;)));;(((,,;;;,,_");
    System.out.println(",;;;;;;;;;;' |)))))))))))\\\\");
    System.out.println(";;;;;;/ )'' - /,)))((((((((((\\");
    System.out.println(";;;;' \\ ~|\\ ))))))))))))))");
    System.out.println("/ / | ((((((((((((((");
    System.out.println("/' \\ _/~' ')|()))))))))");
    System.out.println("/' `\\ /> o_/)))((((((((");
    System.out.println("/ /' `~~(____ / ()))))))))))");
    System.out.println("| ---, \\ \\ ((((((((((");
    System.out.println("`\\ \\~-_____| ))))))))");
    System.out.println("`\\ | |_.---. \\");
  }

  public static void getActionScreen() {
    System.out.println("           _                         _");
    System.out.println("       _==/          i     i          \\==");
    System.out.println("     /XX/            |\\___/|            \\XX\\");
    System.out.println("   /XXXX\\            |XXXXX|            /XXXX\\");
    System.out.println("  |XXXXXX\\_         _XXXXXXX_         _/XXXXXX|");
    System.out.println(" XXXXXXXXXXXxxxxxxxXXXXXXXXXXXxxxxxxxXXXXXXXXXXX");
    System.out.println("|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|");
    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    System.out.println("|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|");
    System.out.println(" XXXXXX/^^^^\"\\XXXXXXXXXXXXXXXXXXXXX/^^^^^\\XXXXXX");
    System.out.println("  |XXX|       \\XXX/^^\\XXXXX/^^\\XXX/       |XXX|");
    System.out.println("    \\XX\\       \\X/    \\XXX/    \\X/       /XX/");
    System.out.println("       \"\\       \"      \\X/      \"       /\"");

  }

  public static void getWatchScreen() {
    System.out.println("    '-.");
    System.out.println("        '-. _____    ");
    System.out.println(" .-._      |     '.  ");
    System.out.println(":  ..      |      :  ");
    System.out.println("'-._+      |    .-'");
    System.out.println(" /  \\     .'i--i");
    System.out.println("/    \\ .-'_/____\\___");
    System.out.println("    .-'  :       ");
  }

  public static void getMovieScreen(Genre genre) throws InterruptedException {
    switch (genre) {
      case 호러:
        getHorrorScreen();
        break;
      case 가족:
        getFamilyScreen();
        break;
      case 액션:
        getActionScreen();
        break;
      case 로맨스:
        getRomanceScreen();
        break;
    }
  }
  
  public static void viewMenu(int page) {
    switch(page) {
      case 0:
        System.out.println("[메인 페이지]");
        System.out.println("**************************************************************");
        System.out.println("*            로그인            *             회원가입        *");
        System.out.println("**************************************************************");
        System.out.println("*            관리자            *              종료           *");
        System.out.println("**************************************************************");
        break;
      case 1:
        System.out.println("[관리자 페이지]");
        System.out.println("**************************************************************");
        System.out.println("*            회원관리          *             영화관리        *");
        System.out.println("**************************************************************");
        System.out.println("*                             종료                           *");
        System.out.println("**************************************************************");

        
        break;
      case 2:
        System.out.println("[회원 페이지]");
        System.out.println("**************************************************************");
        System.out.println("*                         영화 시청                          *");
        System.out.println("**************************************************************");
        System.out.println("*           보고싶어요          *            다시보기        *");
        System.out.println("**************************************************************");
        System.out.println("*          장르별 더보기        *           인기순 더보기    *");
        System.out.println("**************************************************************");
        System.out.println("*            로그아웃           *              종료          *");
        System.out.println("**************************************************************");
        break;
      case 3:
        System.out.println("[회원 관리 페이지]");
        System.out.println("**************************************************************");
        System.out.println("*            회원추가          *            회원조회         *");
        System.out.println("**************************************************************");
        System.out.println("*            회원수정          *            회원삭제         *");
        System.out.println("**************************************************************");
        break;
      case 4:
        System.out.println("[영화 관리 페이지]");
        System.out.println("**************************************************************");
        System.out.println("*            영화추가          *            영화조회         *");
        System.out.println("**************************************************************");
        System.out.println("*            영화수정          *            영화삭제         *");
        System.out.println("**************************************************************");
        break;
    }
  }
}

/*

 **************************************************************
 *            회원관리          *             영화관리        *
 **************************************************************
 *                             종료                           *
 **************************************************************


 **************************************************************
 *            회원추가          *            회원조회         *
 **************************************************************
 *            회원수정          *            회원삭제         *
 **************************************************************


 **************************************************************
 *            영화추가          *            영화조회         *
 **************************************************************
 *            영화수정          *            영화삭제         *
 **************************************************************


 */
/*
/* 

         
         
         
 *            관리자            *              종료              *
 **************************************************************

 */




/*
**************************************************************
*                         영화 시청                            *
**************************************************************
*           보고싶어요          *            다시보기             *
**************************************************************
*          장르별 더보기         *           인기순 더보기          *
**************************************************************
*            로그아웃           *              종료             *
**************************************************************
*/

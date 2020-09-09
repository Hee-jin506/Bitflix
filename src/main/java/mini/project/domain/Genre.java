package mini.project.domain;

public enum Genre {
   로맨스 {
    @Override
    public String toString() {
      return "로맨스";
    }
  }, 
  
  액션{
    @Override
    public String toString() {
      return "액션";
    }

  }, 
  
  호러 {
    @Override
    public String toString() {
      return "호러";
    }
  }, 
  
  가족 {
    @Override
    public String toString() {
      return "가족";
    }
  }
}
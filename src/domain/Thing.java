package domain;
import java.awt.Color;

/**
 *
 */
public interface Thing{
  int SQUARE = 2;

  void decide();
   
  default void change(){
  };
   default void faseOne(){
    };
  default void faseTwo(){
    };
  default void faseThree(){
    };
  default int shape(){
      return SQUARE;
  }
  
  default Color getColor(){
      return Color.green;
  };
  
  default boolean isActive(){
      return false;
  }
  
}

import java.util.*;
class XO{
public static String Board[]={"1","2","3","4","5","6","7","8","9"};
public static int pc=1,n=0;
public static Scanner sc=new Scanner(System.in);
public static void Print(){
    for(int i=0;i<9;i++){
        if(i%3==0&&i!=0){
            System.out.println();
            System.out.println("-------------");
            System.out.print(" "+Board[i]+" |");
        }
        else{
            System.out.print(" "+Board[i]+" |");
        }
    }
    System.out.println("\n");
}
public static void GetInput(){
    if(n==1&&pc%2==0){
        System.out.println("Computer's turn");
        GetInputCom();
    }
    else{
        System.out.println("Player "+(pc%2!=0 ? "X":"O")+"'s turn");
        System.out.print("Enter a Position : ");
        int p=sc.nextInt();
        Insert(p,pc%2!=0 ? "X":"O");
    }
}
public static void Insert(int p , String pn){
    if(p>0&&p<=9){
        if(!Board[p-1].equals("X")&&!Board[p-1].equals("O")){
            if(n==1&&pc%2==0){
                ComDecideWin(p,pn);
            }
            else{
                Board[p-1]=pn;
            }
            System.out.println();
            Print();
            System.out.println();
            pc++;
            if(Decide()){
                System.out.println();
                System.out.println("PLAYER "+pn+" WON");
                System.exit(0);
            }
            else if(pc==10){
                System.out.println();
                System.out.println("DRAW");
                System.exit(0);
            }
        }    
        else{
            System.out.println();
            System.out.println("Alerady Occupied");
            GetInput();
        }
    }
    else{
        System.out.println("Undefined place");
        GetInput();
    }
}
public static boolean Decide(){
        for (int i = 0; i < 3; i++) {
        if (Board[i*3].equals(Board[i*3 + 1]) && Board[i*3 + 1].equals(Board[i*3 + 2])) {
            return true;
        }
        if (Board[i].equals(Board[i + 3]) && Board[i + 3].equals(Board[i + 6])) {
            return true;
        }
    }
      if(Board[0].equals(Board[4])&&Board[4].equals(Board[8])||Board[2].equals(Board[4])&&Board[4].equals(Board[6])){
          return true;
      }
    return false;
}
public static void GetInputCom(){
    int p=(int)(Math.random()*9)+1;
    if(pc==2&&!Board[4].equals("X") && !Board[4].equals("O")){
        p=5;
    }
    else if(pc<=6){
        for(int i=0;i<9;i+=2){
            p=(!Board[i].equals("X") && !Board[i].equals("O") ? (i+1) : p);
        }
    }
    if(isPositionAvailable(p)){
	    Insert(p,pc%2!=0 ? "X":"O");
    }
    else{
        GetInputCom();
    }
}
    public static boolean isPositionAvailable(int p) {
        return !Board[p - 1].equals("X") && !Board[p - 1].equals("O");
    }
    public static void ComDecideWin(int p,String pn){
        int count=0;
          for (int i = 0; i < 3; i++) {
            if (Board[i*3].equals("O") && Board[i*3 + 1].equals("O")&&!Board[i*3+2].equals("X")) {
                count++;
                if(count==1){
                    Board[i*3+2]=pn;
                }
            }
            if (Board[i*3].equals("O") && Board[i*3 + 2].equals("O")&&!Board[i*3+1].equals("X")) {
                count++;
                if(count==1){
                    Board[i*3+1]=pn;
                }
            }
            if (Board[i*3+2].equals("O") && Board[i*3 + 1].equals("O")&&!Board[i*3].equals("X")) {
                count++;
                if(count==1){
                    Board[i*3]=pn;
                }
            }
            if (Board[i].equals("O") && Board[i + 3].equals("O") &&!Board[i + 6].equals("X")){
                  count++;
                if(count==1){
                    Board[i+6]=pn;
                }
            }
             if (Board[i].equals("O") && Board[i + 6].equals("O") &&!Board[i + 3].equals("X")){
                  count++;
                if(count==1){
                    Board[i+3]=pn;
                }
            }
             if (Board[i+6].equals("O") && Board[i + 3].equals("O") &&!Board[i].equals("X")){
                  count++;
                if(count==1){
                    Board[i]=pn;
                }
            }
        }
        if (!Board[0].equals("X") && Board[4].equals("O")&&Board[8].equals("O")) {
              count++;
                if(count==1){
                Board[0]=pn;
                }
        }
         if(Board[0].equals("O")&&Board[4].equals("O")&&!Board[8].equals("X")){
                count++;
                if(count==1){
                Board[8]=pn;   
                }
        }
        if(Board[0].equals("O")&&Board[8].equals("O")&&!Board[4].equals("X")){
                count++;
                if(count==1){
                Board[4]=pn;   
                }
        }
        if(Board[2].equals("O")&&Board[4].equals("O")&&!Board[6].equals("X")){
                count++;
                if(count==1){
                Board[6]=pn;  
                }
        }
        if(Board[2].equals("O")&&Board[6].equals("O")&&!Board[4].equals("X")){
                count++;
                if(count==1){
                Board[4]=pn;  
                }
        }
        if(Board[4].equals("O")&&Board[6].equals("O")&&!Board[2].equals("X")){
                count++;
                if(count==1){
                Board[2]=pn;   
                }
        }
        if(count==0){
            ComDecideBlock(p,pn);
        }
    }
    public static void ComDecideBlock(int p,String pn){
        int count=0;
          for (int i = 0; i < 3; i++) {
            if (Board[i*3].equals("X") && Board[i*3 + 1].equals("X")&&!Board[i*3+2].equals("O")) {
                count++;
                if(count==1){
                    Board[i*3+2]=pn;
                }
            }
            if (Board[i*3].equals("X") && Board[i*3 + 2].equals("X")&&!Board[i*3+1].equals("O")) {
                count++;
                if(count==1){
                    Board[i*3+1]=pn;
                }
            }
            if (Board[i*3+2].equals("X") && Board[i*3 + 1].equals("X")&&!Board[i*3].equals("O")) {
                count++;
                if(count==1){
                    Board[i*3]=pn;
                }
            }
            if (Board[i].equals("X") && Board[i + 3].equals("X") &&!Board[i + 6].equals("O")){
                  count++;
                if(count==1){
                    Board[i+6]=pn;
                }
            }
             if (Board[i].equals("X") && Board[i + 6].equals("X") &&!Board[i + 3].equals("O")){
                  count++;
                if(count==1){
                    Board[i+3]=pn;
                }
            }
             if (Board[i+6].equals("X") && Board[i + 3].equals("X") &&!Board[i].equals("O")){
                  count++;
                if(count==1){
                    Board[i]=pn;
                }
            }
        }
        if (!Board[0].equals("O") && Board[4].equals("X")&&Board[8].equals("X")) {
              count++;
                if(count==1){
                Board[0]=pn;
                }
        }
         if(Board[0].equals("X")&&Board[4].equals("X")&&!Board[8].equals("O")){
                count++;
                if(count==1){
                Board[8]=pn;   
                }
        }
        if(Board[0].equals("X")&&Board[8].equals("X")&&!Board[4].equals("O")){
                count++;
                if(count==1){
                Board[4]=pn;   
                }
        }
        if(Board[2].equals("X")&&Board[4].equals("X")&&!Board[6].equals("O")){
                count++;
                if(count==1){
                Board[6]=pn;  
                }
        }
        if(Board[2].equals("X")&&Board[6].equals("X")&&!Board[4].equals("O")){
                count++;
                if(count==1){
                Board[4]=pn;  
                }
        }
        if(Board[4].equals("X")&&Board[6].equals("X")&&!Board[2].equals("O")){
                count++;
                if(count==1){
                Board[2]=pn;   
                }
        }
        if(count==0){
            Board[p-1]=pn;
        }
    }
public static void main(String args[]){
    System.out.println("TIC TAC TOE GAME ");
    System.out.println("1. Play with Computer \n2. Play with Player");
    System.out.print("CHOOSE GAME MODE ( 1 or 2 ) : ");
    n=sc.nextInt();
    Print();
    while(true){
        GetInput();
        }
    }
}

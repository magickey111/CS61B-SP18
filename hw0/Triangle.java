public class Triangle{
    public static void main(String[] args) {
        
        int row = 1;
        int SIZE = 5;
        while (row <= SIZE){
            int col = 1;
            while (col < row) {
                System.out.print('*');
                col = col + 1;
            }
            if (col == row) {
                System.out.println('*');
                
            }
            row = row + 1;   
        }
        
    }
}

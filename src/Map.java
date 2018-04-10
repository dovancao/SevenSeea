public class Map {
    String[][] data;
    public Map(){
        data = new String[][]{
                {"-","-","-","E","-"},
                {"-","-","-","-","-"},
                {"-","-","S","-","-"},
                {"-","-","-","-","-"},
                {"-","-","-","E","-"},
        };
    }

    public void print(){
        for(String[] row:data){
            for(String cell:row){
                System.out.print(cell);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int height(){
        return data.length;
    }

    public int width(){
        return data[0].length;
    }

    //check xem phan tu co trong map khong
    public boolean isValid(int x, int y) {
        return x>=0 && x<width() && y>=0 && y<height();
    }

    // dem so phan tu co trong map
    public int count(String value){
        int result = 0;
        for(String[] row:data){
            for(String cell:row){
                if(cell.equalsIgnoreCase(value)){
                    result++;
                }
            }
        }
        return result;
    }

    public String cellAt(int x, int y){
        if(!isValid(x,y)) return null;
        return data[y][x];
    }

    // thay the phan tu rong map

    public String setCellAt(int x, int y, String value){
        if(!isValid(x,y)) return null;
        return data[y][x] = value;
    }

}

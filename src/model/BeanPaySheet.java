
package model;


public class BeanPaySheet {
    
    private String COLUMN_1;    
    private String COLUMN_2;

    public BeanPaySheet(String COLUMN_1, String COLUMN_2) {
        this.COLUMN_1 = COLUMN_1;
        this.COLUMN_2 = COLUMN_2;
    }

    public String getCOLUMN_1() {
        return COLUMN_1;
    }

    public void setCOLUMN_1(String COLUMN_1) {
        this.COLUMN_1 = COLUMN_1;
    }

    public String getCOLUMN_2() {
        return COLUMN_2;
    }

    public void setCOLUMN_2(String COLUMN_2) {
        this.COLUMN_2 = COLUMN_2;
    }

   
}
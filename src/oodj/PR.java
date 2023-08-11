/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;

/**
 *
 * @author htankhaishan
 //filepath
// "/Users/ben/Documents/OOPJAVA/OODJ/username.txt"
//"/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/username.txt"
*/


public class PR {
    private String itemCode, itemDescription, quantity;
    private static final String FILENAME = "/Users/htankhaishan/Documents/2nd Year 1st Sem/Java/OODJ/pr.txt";

    public PR(String itemCode, String itemDescription, String quantity) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
    }
    
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
}

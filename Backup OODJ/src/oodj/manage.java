/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oodj;

/**
 *
 * @author htankhaishan
 */
public abstract class manage {
    public abstract void add();
    public abstract void delete(
            String delete
    );
    public abstract void edit(
            String edit, 
            String name, 
            String category, 
            String price, 
            String availability, 
            String code, 
            String descriptions
    );
    public abstract void view();
}

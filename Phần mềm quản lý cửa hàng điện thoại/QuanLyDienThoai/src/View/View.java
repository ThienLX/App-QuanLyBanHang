/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nhom24
 */
public interface View {
    <T> void showData(List<T> list,DefaultTableModel model);
    
}

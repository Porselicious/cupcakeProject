/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Fen
 */
public class TestUsersDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User("Prins","1234");
        user.setBalance(10);
        UsersDAO dao = new UsersDAO();
        dao.createUser(user);
    }
    
}

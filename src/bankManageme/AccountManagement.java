package bankManageme;
import java.util.ArrayList;import java.util.ArrayList;
import java.util.Scanner;
    // Lưu trữ account, thêm, xóa, tìm kiếm....
//AccountManagement
//        ArrayList<Account> accountList …..
//        + addAccount
//        + deleteAccount
//        + searchAccount


    public  class AccountManagement {
        private final ArrayList<Account> accountList = new ArrayList<>();

        public ArrayList<Account> getList() {
            return accountList;
        }
        public void addAccount(Account account) {
            accountList.add(account);
        }

        public void removeAccount(Account account) {
            accountList.remove(account);
        }

        public Account searchByID(long ID) {
            for (Account account: accountList) {
                if( account.getID() == ID) {
                    return account;
                }
            }

                    System.out.println("ID không hợp lệ!!!");
                  return   null;
        }

    public static void display(Account account)
    {
        System.out.println(account.toString());
    }

}


package com.phonestore.dao;

import com.phonestore.context.DBContext;
import com.phonestore.model.Account;
import com.phonestore.model.Category;
import com.phonestore.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static final String SELECT_ALL_ACCOUNT = "SELECT * FROM ACCOUNT";
    private static final String SELECT_ACCOUNT_BY_ID = "SELECT * FROM ACCOUNT WHERE uID = ?";
    private static final String EDIT_ACCOUNT = "UPDATE `account` SET  `isSell` = ?, `isAdmin` = ? WHERE (`uID` = ?);\n";
    final String EDIT_PRODUCT = "UPDATE `product` SET `name` = ?, `image` = ?, `price` = ?, `title` = ?, `description` = ?, `cid` = ? WHERE (`id` = ?);\n";
    final String INSERT_PRODUCT = "INSERT INTO `product` (`name`, `image`, `price`, `title`, `description`, `cid`, `sellid`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ?";
    final String SELECT_PRODUCT_BY_SELLID = "SELECT * FROM product WHERE SELLID = ?\n";
    final String SELECT_ALL_PRODUCT = "select * from product";
    final String SEARCH_BY_NAME = "SELECT * FROM product WHERE NAME LIKE ?";
    final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ?";
    final String SELECT_ALL_CATEGORY = "SELECT * FROM CATEGORY";
    final String SELECT_NEWEST_PRODUCT = "SELECT * FROM product\n" +
            "ORDER BY id DESC\n" +
            "LIMIT 1";
    final String SELECT_PRODUCT_BY_CATEGORY = "SELECT * FROM product WHERE cid = ?";
    final String SELECT_ACCOUNT = "SELECT * FROM account \n" +
            "WHERE user = ?\n" +
            "AND pass = ?";
    final String CHECK_ACCOUNT = "SELECT * FROM account \n" +
            "WHERE user = ?\n";
    final String SIGN_UP = "INSERT INTO `account` (`user`, `pass`, `isSell`, `isAdmin`) VALUES (?, ?, '0', '0');\n";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<Product> getAllProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> searchByName(String txtString) {
        List<Product> productList = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + txtString + "%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Category> getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryList.add(new Category(resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public Product getLast() {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_NEWEST_PRODUCT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Product> getProductByCategory(String cid) {
        List<Product> productList = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CATEGORY);
            preparedStatement.setString(1, cid);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                productList.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public Product getProductById(String id) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Product getProductById(int id) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account login(String username, String password) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ACCOUNT);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Product> getProductBySellId(int sellId) {
        List<Product> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_SELLID);
            preparedStatement.setInt(1, sellId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Product(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteProduct(String pid) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setString(1, pid);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertProduct(Product product) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getTitle());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.setInt(7, product.getSellID());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editProduct(Product product) {
        //"UPDATE `product` SET `name` = ?, `image` = ?, `price` = ?, `title` = ?, `description` = ?, `cid` = ? WHERE (`id` = ?);"
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(EDIT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getImage());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setString(4, product.getTitle());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCategory());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Account checkUser(String username) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(CHECK_ACCOUNT);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public void signUp(String user, String pass) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SIGN_UP);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, pass);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNT);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
                list.add(new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account getAccountById(String id) {
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_ID);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               return new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void editAccount(int isSell, int isAdmin, int id) {
        //UPDATE `account` SET  `isSell` = ?, `isAdmin` = ? WHERE (`uID` = ?)
        try {
            connection = new DBContext().getConnection();
            preparedStatement = connection.prepareStatement(EDIT_ACCOUNT);
            preparedStatement.setInt(1,isSell);
            preparedStatement.setInt(2,isAdmin);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

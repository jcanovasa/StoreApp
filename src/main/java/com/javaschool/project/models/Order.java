 package com.javaschool.project.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


 @Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /* Usamos la anotación @ManyToMany para establecer la relación de muchos a muchos con la clase productos.
    La Anotación @joinColumn se usa para especificar el nombre de la tabla de enlace que se creará para almacenar
    la relación entre las tablas de cestas y productos. Las anotaciones @JoinColumn se utilizan para especificar
    el nombre de las columnas en la tabla de enlace que almacenarán las claves foráneas que se refieren a las
    claves primarias de las tablas de cestas y productos, respectivamente.
    */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_in_cart",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

     /*public Order(Long id, List<Product> products) {
         this.id = id;
         this.products = products;
     }*/

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public List<Product> getProducts() {
         return products;
     }

     public void setProducts(List<Product> products) {
         this.products = products;
     }

     public void addProduct(Product product) {
         this.products.add(product);
     }
 }




/*

@Entity
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String apellidos;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cesta_id", referencedColumnName = "id")
  private Cesta cesta;

  // getters y setters
}

 @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable{

    }
    private ArrayList<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
 */



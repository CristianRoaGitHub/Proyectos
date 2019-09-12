package com.crisoft.restaurante.control;

import com.crisoft.restaurante.dao.CategoriaDao;
import com.crisoft.restaurante.dao.ProductoDao;
import com.crisoft.restaurante.vo.CategoriaProducto;
import com.crisoft.restaurante.vo.DetalleVenta;
import com.crisoft.restaurante.vo.Persona;
import com.crisoft.restaurante.vo.Producto;
import com.crisoft.restaurante.vo.ProductoDetalleVenta;
import com.crisoft.restaurante.vo.Venta;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author CROA
 */

/*
Colocar este <f:selectItem itemValue="C" itemLabel="Cliente" con estado 1/>

actualizar comoponenete label para la suma de los produntos

//www.primefaces.org/showcase/ui/input/spinner.xhtml

 */
@ManagedBean
@SessionScoped

public class DetalleVentaController implements Serializable {

    private int codigoCat;
    private int codigoPro;
    private String nombrePro;
    
    private CategoriaProducto categoria = new CategoriaProducto();

    private double precioProducto = 0;

    private List<SelectItem> SelectItemsOneCategoria;
    private List<SelectItem> SelectItemsOneProducto;

    
    //detalle de los productos
    private  List<ProductoDetalleVenta> listaProductoDetalle = new ArrayList<>();

    
    private  Venta venta = new Venta();
            
    //generacion de factura
    private String fecha;
    private String fechaFacturaFinal;
    private int cantidadP = 0;

    public DetalleVentaController() {

    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(int codigoCat) {
        this.setPrecioProducto(0);
        this.codigoCat = codigoCat;
    }

    public int getCodigoPro() {
        return codigoPro;
    }

    public void setCodigoPro(int codigoPro) {
        //System.out.println(" codigo producto 2: " +codigoPro);
        this.setPrecioProducto(metodoPrecioProducto(codigoPro));
        this.codigoPro = codigoPro;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    
    public int getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    public void setSelectItemsOneCategoria(List<SelectItem> SelectItemsOneCategoria) {
        this.SelectItemsOneCategoria = SelectItemsOneCategoria;
    }

    public void setSelectItemsOneProducto(List<SelectItem> SelectItemsOneProducto) {
        this.SelectItemsOneProducto = SelectItemsOneProducto;
    }


    
    public  List<ProductoDetalleVenta> getListaProductoDetalle() {
        return listaProductoDetalle;
    }

    public  void setListaProductoDetalle(List<ProductoDetalleVenta> listaProductoDetalle) {
        listaProductoDetalle = listaProductoDetalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaFacturaFinal() {
        return fechaFacturaFinal;
    }

    public void setFechaFacturaFinal(String fechaFacturaFinal) {
        this.fechaFacturaFinal = fechaFacturaFinal;
    }

    

    
    // Metodos
    public String fechaFactura(int valor) {

        String patronFecha = "";
        String fechasalida = "";
        Date fecha = new Date();

        if (valor == 1) {
            patronFecha = "yyyy-MM-dd HH:mm:ss";
        } else if (valor == 2) {
            //  System.out.println("Entro a esta opcion");
            patronFecha = "yyyy/MM/dd";
        }
        SimpleDateFormat df = new SimpleDateFormat(patronFecha);
        fechasalida = df.format(fecha);
        //System.out.println("La fecha de salida es " +fechasalida);
        return fechasalida;
    }

    //---
    public List<SelectItem> getSelectItemsOneCategoria() {
        this.SelectItemsOneCategoria = new ArrayList<SelectItem>();
        CategoriaDao catDao = new CategoriaDao();
        List<CategoriaProducto> categorias = catDao.listaCategoriasBD(0);
        SelectItemsOneCategoria.clear();
        for (CategoriaProducto misCategorias : categorias) {
            SelectItem selectItem = new SelectItem(misCategorias.getCatIdAuto(), misCategorias.getCatTipo());
            this.SelectItemsOneCategoria.add(selectItem);
        }
        return SelectItemsOneCategoria;
    }

    public List<SelectItem> getSelectItemsOneProducto() {
        this.SelectItemsOneProducto = new ArrayList<SelectItem>();
        ProductoDao proDao = new ProductoDao();

        List<Producto> productos = proDao.listaProductoBD(codigoCat, "productoPorCategoria");

        SelectItemsOneProducto.clear();
        for (Producto miProducto : productos) {
            SelectItem selectItem = new SelectItem(miProducto.getProIdAuto(), miProducto.getProNombre());
            this.SelectItemsOneProducto.add(selectItem);
        }

        return SelectItemsOneProducto;
    }

    public double metodoPrecioProducto(int codigoP) {

        double precio = 0;
        Producto pro = new Producto();
        ProductoDao proDao = new ProductoDao();
        List<Producto> listaProdBD = proDao.listaProductoBD(codigoP, "producto");

        for (Producto producto : listaProdBD) {
            pro = producto;
        }
        this.nombrePro = pro.getProNombre();
        return precio = pro.getProPrecioProducto();
    }

    public void agregarDetalleventa() {

        //System.out.println("Codigo del producto " + codigoPro);
        
        Producto pro = new Producto();
        pro.setProIdAuto(codigoPro);
        pro.setProNombre(nombrePro);
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setDetIdAuto(0);

        //Persona per = new  Persona();
//        per.setPerIdCedula("1019");
//        detalleVenta.setDetPerIdCedula(per);
        //pro.setProIdAuto(codigoPro);
//        detalleVenta.setDetProIdAuto(pro);

        detalleVenta.setDetPrecioProducto(precioProducto);
        detalleVenta.setDetCantidadProducto(cantidadP);
        
        ProductoDetalleVenta productoDetalle = new ProductoDetalleVenta();
        productoDetalle.setProducto(pro);
        productoDetalle.setDetalleVenta(detalleVenta);
        listaProductoDetalle.add(productoDetalle);
        
        
        verDetalleConsumo(listaProductoDetalle);
    }


            
    public void verDetalleConsumo(List<ProductoDetalleVenta> proDetVen) {
        
        try {

            int cantidadProductos = 0;
            double precioValorTotalProductos = 0;

            for (ProductoDetalleVenta pdv : proDetVen) {
                cantidadProductos += pdv.getDetalleVenta().getDetCantidadProducto();
                precioValorTotalProductos += pdv.getDetalleVenta().getDetCantidadProducto() * pdv.getDetalleVenta().getDetPrecioProducto();
            }

            venta.setVenDetCodDetallesAut(0);
            venta.setVenNombreOperario("William Ferrari");
            venta.setVenMesa("A1");
            venta.setVenCantidadTotal(cantidadProductos);
            venta.setVenValorTotal(precioValorTotalProductos);
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = formatter.parse(fechaFactura(1));
            
            venta.setVenFecha(date);
            venta.setVenObservacion("Descripcion de la venta");
            
            
        } catch (Exception e) {
            System.out.println("Error en DetalleVentaController, Metodo calcularVenta() " + e);
        }

     
    }

    public void generarFactura() {
       // this.fechaFacturaFinal = fechaFactura(2);
        System.out.println("La fecha es " + this.venta.getVenFecha());
        
        
        
        

    }

    @PostConstruct
    public void init() {
        fecha = fechaFactura(1);
    }
}

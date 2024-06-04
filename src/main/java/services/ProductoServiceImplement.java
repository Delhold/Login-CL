package services;

import models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImplement implements ProductoService {


    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1, "laptop", "computación", "hp i5",254.5),
                new Producto(2,"audifonos","implementos","corsair-g56",50.25),
                new Producto(3,"mouse","implementos","hyper-x",25.75),
                new Producto(4,"SDD","computacion","500gb",100.25),
                new Producto(5,"monitor","hardware","1Tb",60.55));
    };
}
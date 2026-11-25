const express = require('express');
const app = express();
app.use(express.json());

// Datos en memoria
let clientes = [];
let productos = [];
let pedidos = [];
let idCliente = 1, idProducto = 1, idPedido = 1;

// ========== CLIENTES ==========
app.post('/api/clientes', (req, res) => {
    const { nombre, apellido, email } = req.body;
    if (!nombre || !apellido || !email) {
        return res.status(400).json({ mensaje: "Error: Nombre, apellido y email son obligatorios." });
    }
    const cliente = { id: idCliente++, nombre, apellido, email };
    clientes.push(cliente);
    res.status(201).json({ mensaje: "Cliente creado correctamente.", cliente });
});

app.get('/api/clientes', (req, res) => {
    res.json(clientes);
});

// ========== PRODUCTOS ==========
app.post('/api/productos', (req, res) => {
    const { nombre, precio, stock } = req.body;
    if (!nombre || precio == null || stock == null) {
        return res.status(400).json({ mensaje: "Error: Nombre, precio y stock son obligatorios." });
    }
    if (precio < 0 || stock < 0) {
        return res.status(400).json({ mensaje: "Error: Precio y stock no pueden ser negativos." });
    }
    const producto = { id: idProducto++, nombre, precio, stock };
    productos.push(producto);
    res.status(201).json({ mensaje: "Producto creado correctamente.", producto });
});

app.get('/api/productos', (req, res) => {
    res.json(productos);
});

// ========== PEDIDOS ==========
app.post('/api/pedidos', (req, res) => {
    const { idCliente, idProducto, cantidad } = req.body;
    if (!idCliente || !idProducto || !cantidad) {
        return res.status(400).json({ mensaje: "Error: idCliente, idProducto y cantidad son obligatorios." });
    }
    const pedido = { id: idPedido++, idCliente, idProducto, cantidad, fecha: new Date().toISOString() };
    pedidos.push(pedido);
    res.status(201).json({ mensaje: "Pedido creado correctamente.", pedido });
});

app.get('/api/pedidos', (req, res) => {
    res.json(pedidos);
});

app.listen(8080, () => {
    console.log('API del proyecto corriendo en http://localhost:8080');
});

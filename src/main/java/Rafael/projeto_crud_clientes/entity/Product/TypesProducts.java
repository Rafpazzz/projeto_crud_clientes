package Rafael.projeto_crud_clientes.entity.Product;

public enum TypesProducts {
    PLACA_MAE("placa_mae"),
    PROCESSADOR("processador");


    private String type;

    TypesProducts(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

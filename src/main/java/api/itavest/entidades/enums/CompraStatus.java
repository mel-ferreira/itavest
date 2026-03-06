package api.itavest.entidades.enums;

public enum CompraStatus {
    PAGAMENTO_PENDENTE(1),
    PAGO(2),
    CANCELADO(3);

    private int codigo;

    private CompraStatus(int codigo)
    {
        this.codigo = codigo;
    }
    public static CompraStatus valueOf(int codigo)
    {
        for (CompraStatus value : CompraStatus.values())
        {
            if(value.getCodigo() == codigo)
            {
                return value;
            }
        }
        throw new IllegalArgumentException("O código é inválido");
    }

    public int getCodigo() {
        return codigo;
    }
}

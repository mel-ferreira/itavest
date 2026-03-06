package api.itavest.entidades.enums;

public enum PagamentoStatus {
    PENDENTE(1),
    EXECUTADO(2),
    CANCELADO(3);

    private int codigo;

    PagamentoStatus(int codigo)
    {
        this.codigo = codigo;
    }
    public static PagamentoStatus valueOf(int codigo)
    {
        for (PagamentoStatus value : PagamentoStatus.values())
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

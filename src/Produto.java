public class Produto {
    private String nome;
    private double valor;
    private int qtdEstoque;
    private Fornecedor fornecedor;

    public Produto(String nome, double valor, int qtdEstoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public void setFornecedor(Menu menu) {
        this.fornecedor = fornecedor;
    }
}

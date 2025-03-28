import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class Menu {
    private final Fornecedor[] fornecedor = new Fornecedor[3];
    private final Produto[] produto = new Produto[5];
    private int indexProduto = 0;
    private int indexFornecedor = 0;

    public void menu() {
        int opcao;
        int resposta;
        String aux = "Escolha uma opção:\n";
        aux += "1. Cadastrar produto\n";
        aux += "2. Pesquisar produto por nome\n";
        aux += "3. Pesquisar fornecedor por CNPJ\n";
        aux += "4.Finalizar\n";

        while (true) {
            opcao = parseInt(showInputDialog(aux));
            if (opcao == 4) {
                resposta = showConfirmDialog(null, "Tem certeza que deseja finalizar?");
                if (resposta == YES_OPTION) {
                    break;
                }
            }
            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção Inválida");
            } else {
                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        pesquisarProduto();
                        break;
                    case 3:
                        pesquisarFornecedor();
                        break;
                }
            }
        }
    }

    public void cadastrarProduto() {
        Fornecedor fornecedor = pesquisarFornecedor();
        String nome;
        double valor;
        int qtdEstoque;
        if (fornecedor == null) {
            fornecedor = cadastrarFornecedor();
        }

        nome = showInputDialog("Nome");
        valor = parseDouble(showInputDialog("Valor unitário"));
        qtdEstoque = parseInt(showInputDialog("Quantidade e estoque"));
        produto[indexProduto] = new Produto(nome, valor, qtdEstoque, fornecedor);
        indexProduto++;

    }

    public void pesquisarProduto() {
        DecimalFormat df = new DecimalFormat("0.00");
        String nome = showInputDialog("Nome do produto");
        String aux = "";

        for (int i = 0; i < indexProduto; i++) {
            if (produto[i].getNome().equalsIgnoreCase(nome)) {
                aux += "Nome do produto: " + nome + "\n";
                aux += "Preço unitário R$ " + df.format(produto[i].getValor()) + "\n";
                aux += "Quantidade em estoque: " + produto[i].getQtdEstoque() + "\n";
                aux += "Fornecedor: " + produto[i].getFornecedor().getNome();
                break;
            }
        }
        showMessageDialog(null, aux);
    }

    private Fornecedor pesquisarFornecedor() {
        long cnpj = parseLong(showInputDialog("CNPJ"));
        for (int i = 0; i < indexFornecedor; i++) {
            if (fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, cnpj + "não encontrado:");
        return null;
    }

    private Fornecedor cadastrarFornecedor() {
        String nome;
        long cnpj;
        Fornecedor f = null;
        if (indexFornecedor < fornecedor.length) {
            nome = showInputDialog("Nome");
            cnpj = parseLong(showInputDialog("CNPJ"));
            f = new Fornecedor(nome, cnpj);
            fornecedor[indexFornecedor] = f;
            indexFornecedor++;
        }
        return f;
    }

}

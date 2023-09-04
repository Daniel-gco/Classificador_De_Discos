public class Classificador {
    private float valorDisco;
    private float valorDiscoCorrigido;
    private float valorPrecisao;
    private final float desvioPadraoMedio;
    private final String resultado;

    public String getResultado() {
        return resultado;
    }

    public float getDesvioPadraoMedio(){
        return this.desvioPadraoMedio;
    }

    public float getValorDiscoCorrigido() {
        return valorDiscoCorrigido;
    }

    public void setValorDiscoCorrigido(float valorDiscoCorrigido) {
        this.valorDiscoCorrigido = valorDiscoCorrigido;
    }

    public float getValorDisco() {
        return valorDisco;
    }

    public void setValorDisco(float valorDisco) {
        this.valorDisco = valorDisco;
    }

    public float getValorPrecisao() {
        return valorPrecisao;
    }

    public void setValorPrecisao(float valorPrecisao) {
        this.valorPrecisao = valorPrecisao;
    }

    public Classificador(float media, float desvioPadrao, float valorCorrecao,
                               int numeroMedicoes, float t, float tolerancia, float valorDesejado){
        this.valorDisco = media;
        this.valorDiscoCorrigido = media + valorCorrecao;

        float raizNumeroMedicoes = (float) Math.sqrt(numeroMedicoes);

        this.desvioPadraoMedio = (desvioPadrao / raizNumeroMedicoes);
        this.valorPrecisao = (desvioPadraoMedio *t) / raizNumeroMedicoes;

        float valorMin = valorDesejado - tolerancia;
        float valorMax = valorDesejado + tolerancia;

        float faixaDuvidaMin1 = valorMin - valorPrecisao;
        float faixaDuvidaMin2 = valorMin + valorPrecisao;
        float faixaDuvidaMax1 = valorMax - valorPrecisao;
        float faixaDuvidaMax2 = valorMax + valorPrecisao;

        if (this.valorDiscoCorrigido < faixaDuvidaMin1 || this.valorDiscoCorrigido > faixaDuvidaMax2){
            this.resultado = "Vermelho";
        } else if(this.valorDiscoCorrigido < faixaDuvidaMin2 || this.valorDiscoCorrigido > faixaDuvidaMax1) {
            this.resultado = "Amarelo";
        } else {
            this.resultado = "Verde";
        }
    }
}

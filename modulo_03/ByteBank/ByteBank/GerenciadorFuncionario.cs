using System;
using ByteBank.Funcionarios;
namespace ByteBank
{
    public class GerenciadorFuncionario
    {
        private double _totalBonificacao;

        public void Registrar(Funcionario funcionario)
        {
            _totalBonificacao += funcionario.GetBonificacao(); 

        }

        public double GetTotalBonificacao()
        {
            return _totalBonificacao;

        }
    }
}

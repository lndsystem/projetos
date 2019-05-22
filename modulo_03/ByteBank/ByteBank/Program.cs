using System;
using ByteBank.Funcionarios;
using static System.Console;

namespace ByteBank
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            GerenciadorFuncionario g = new GerenciadorFuncionario();

            Funcionario carlos = new Funcionario();
            carlos.Nome = "Carlos";
            carlos.CPF = "567.891.238-01";
            carlos.Salario = 2000;
            WriteLine(carlos.GetBonificacao());
            g.Registrar(carlos);




            Diretor roberta = new Diretor();
            roberta.Nome = "Roberta";
            roberta.CPF = "345.678.948-34";
            roberta.Salario = 5000;
            g.Registrar(roberta);

            WriteLine(roberta.GetBonificacao());
            WriteLine("Total bonificacao: \n" + g.GetTotalBonificacao());
            ReadLine();
        }
    }
}

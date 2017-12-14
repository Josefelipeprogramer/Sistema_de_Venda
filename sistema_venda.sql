-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 14-Dez-2017 às 02:02
-- Versão do servidor: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistema_venda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `COD_COMPRA` int(11) NOT NULL,
  `VALOR_COMPRA` float NOT NULL,
  `DATA_COMPRA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `item_venda`
--

CREATE TABLE `item_venda` (
  `COD_ITEM` int(11) NOT NULL,
  `CPF_VENDEDOR` int(11) NOT NULL,
  `COD_PRODUTO` int(11) NOT NULL,
  `QTD` int(11) NOT NULL,
  `DATA_VENDA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `COD_PRODUTO` int(11) NOT NULL,
  `NOME_PRODUTO` varchar(80) NOT NULL,
  `COD_TIPO` int(11) NOT NULL,
  `QTD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_preço`
--

CREATE TABLE `produto_preço` (
  `COD` int(11) NOT NULL,
  `COD_PRODUTO` int(11) NOT NULL,
  `DATA_INICIO` date NOT NULL,
  `DATA_FIM` date NOT NULL,
  `PREÇO_VENDA` float NOT NULL,
  `MEDIA_PREÇO_COMPRA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_produto`
--

CREATE TABLE `tipo_produto` (
  `COD_TIPO` int(11) NOT NULL,
  `DESC_TIPO` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `COD_VENDA` int(11) NOT NULL,
  `CPF_VENDEDOR` int(11) NOT NULL,
  `VALOR_VENDA` float NOT NULL,
  `DATA_VENDA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendedor`
--

CREATE TABLE `vendedor` (
  `CPF_VENDEDOR` int(11) NOT NULL,
  `NOME` varchar(80) NOT NULL,
  `ENDERECO` varchar(80) DEFAULT NULL,
  `TELEFONE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendedor`
--

INSERT INTO `vendedor` (`CPF_VENDEDOR`, `NOME`, `ENDERECO`, `TELEFONE`) VALUES
(112, 'Lucas', 'phoc II', 78798944),
(123, 'Rainan', 'phoc I', 99663322),
(445, 'Áquila', 'Gleba E', 66988774),
(456, 'Dynarte', 'limoeiro', 77441122),
(654, 'Brenda Dultra', 'Inocoop', 98681288),
(779, 'Douglas Rodrigues Aguiar de Oliveira', 'São Paulo', 41535048),
(786, 'André Dias', 'Lama Preta', 97984656),
(889, 'Alguém', 'Rua dos bobos', 22556699),
(987, 'Debora', 'Mata de São João', 88552277);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`COD_COMPRA`);

--
-- Indexes for table `item_venda`
--
ALTER TABLE `item_venda`
  ADD PRIMARY KEY (`COD_ITEM`),
  ADD KEY `CPF_VENDEDOR` (`CPF_VENDEDOR`),
  ADD KEY `COD_PRODUTO` (`COD_PRODUTO`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`COD_PRODUTO`),
  ADD KEY `COD_TIPO` (`COD_TIPO`);

--
-- Indexes for table `produto_preço`
--
ALTER TABLE `produto_preço`
  ADD PRIMARY KEY (`COD`),
  ADD KEY `COD_PRODUTO` (`COD_PRODUTO`);

--
-- Indexes for table `tipo_produto`
--
ALTER TABLE `tipo_produto`
  ADD PRIMARY KEY (`COD_TIPO`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`COD_VENDA`),
  ADD KEY `CPF_VENDEDOR` (`CPF_VENDEDOR`);

--
-- Indexes for table `vendedor`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`CPF_VENDEDOR`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `compra`
--
ALTER TABLE `compra`
  MODIFY `COD_COMPRA` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `item_venda`
--
ALTER TABLE `item_venda`
  ADD CONSTRAINT `item_venda_ibfk_1` FOREIGN KEY (`CPF_VENDEDOR`) REFERENCES `vendedor` (`CPF_VENDEDOR`),
  ADD CONSTRAINT `item_venda_ibfk_3` FOREIGN KEY (`COD_PRODUTO`) REFERENCES `produto` (`COD_PRODUTO`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`COD_TIPO`) REFERENCES `tipo_produto` (`COD_TIPO`);

--
-- Limitadores para a tabela `produto_preço`
--
ALTER TABLE `produto_preço`
  ADD CONSTRAINT `produto_preço_ibfk_1` FOREIGN KEY (`COD_PRODUTO`) REFERENCES `produto` (`COD_PRODUTO`),
  ADD CONSTRAINT `produto_preço_ibfk_2` FOREIGN KEY (`COD_PRODUTO`) REFERENCES `produto` (`COD_PRODUTO`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`CPF_VENDEDOR`) REFERENCES `vendedor` (`CPF_VENDEDOR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

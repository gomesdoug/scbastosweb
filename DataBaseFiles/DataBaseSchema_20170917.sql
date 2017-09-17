CREATE DATABASE  IF NOT EXISTS `scbastosdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `scbastosdb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: scbastosdb
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bairro` (
  `codigo` bigint(20) NOT NULL,
  `codigo_municipio` bigint(20) NOT NULL,
  `nome_bairro` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_bairro_municipio1_idx` (`codigo_municipio`),
  CONSTRAINT `fk_bairro_municipio1` FOREIGN KEY (`codigo_municipio`) REFERENCES `municipio` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dependencia`
--

DROP TABLE IF EXISTS `dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dependencia` (
  `codigo` bigint(20) NOT NULL,
  `nome_dependencia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_bairro` bigint(20) NOT NULL,
  `logradouro` varchar(100) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `data_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`codigo`),
  KEY `fk_endereco_bairro1_idx` (`codigo_bairro`),
  CONSTRAINT `fk_endereco_bairro1` FOREIGN KEY (`codigo_bairro`) REFERENCES `bairro` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `codigo` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo_permissao`
--

DROP TABLE IF EXISTS `grupo_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_permissao` (
  `codigo_grupo` bigint(20) NOT NULL,
  `codigo_permisao` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo_grupo`,`codigo_permisao`),
  KEY `fk_grupo_permissao_permisao1_idx` (`codigo_permisao`),
  CONSTRAINT `fk_grupo_permissao_grupo1` FOREIGN KEY (`codigo_grupo`) REFERENCES `grupo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_permissao_permisao1` FOREIGN KEY (`codigo_permisao`) REFERENCES `permissao` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imovel`
--

DROP TABLE IF EXISTS `imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imovel` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_endereco` bigint(20) DEFAULT NULL,
  `codigo_usuario` bigint(20) DEFAULT NULL,
  `codigo_valor` bigint(20) DEFAULT NULL,
  `codigo_proprietario` bigint(20) DEFAULT NULL,
  `codigosc` bigint(20) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `insc_imob` varchar(45) NOT NULL,
  `tipo_imovel` varchar(45) DEFAULT NULL,
  `exclusividade_imovel` varchar(45) NOT NULL,
  `data_captacao` date DEFAULT NULL,
  `data_cadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  `idade_imovel` int(11) DEFAULT NULL,
  `status_imovel` varchar(45) NOT NULL,
  `destinacao` varchar(45) DEFAULT NULL,
  `area_total` decimal(10,2) DEFAULT NULL,
  `garagem` int(11) NOT NULL,
  `situacao` varchar(45) DEFAULT NULL,
  `classificacao` varchar(45) DEFAULT NULL,
  `conservacao` varchar(45) DEFAULT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `content_type` varchar(100) DEFAULT NULL,
  `corretor` varchar(45) NOT NULL,
  `opcionista` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigosc_UNIQUE` (`codigosc`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  UNIQUE KEY `insc_imob_UNIQUE` (`insc_imob`),
  KEY `fk_imovel_endereco1_idx` (`codigo_endereco`),
  KEY `fk_imovel_usuario1_idx` (`codigo_usuario`),
  KEY `fk_imovel_valor1_idx` (`codigo_valor`),
  KEY `fk_imovel_proprietario1_idx` (`codigo_proprietario`),
  CONSTRAINT `fk_imovel_endereco1` FOREIGN KEY (`codigo_endereco`) REFERENCES `endereco` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_proprietario1` FOREIGN KEY (`codigo_proprietario`) REFERENCES `proprietario` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_usuario1` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_valor1` FOREIGN KEY (`codigo_valor`) REFERENCES `valor` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imovel_dependencia`
--

DROP TABLE IF EXISTS `imovel_dependencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imovel_dependencia` (
  `codigo_imovel` bigint(20) NOT NULL,
  `codigo_dependencia` bigint(20) NOT NULL,
  `area` decimal(10,2) DEFAULT NULL,
  `qtd_dependencia` int(11) DEFAULT NULL,
  `tipo_piso` varchar(45) DEFAULT NULL,
  `comprimento` decimal(10,2) DEFAULT NULL,
  `largura` decimal(10,2) DEFAULT NULL,
  `altura` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigo_imovel`,`codigo_dependencia`),
  KEY `fk_imovel_dependencia_dependencia1_idx` (`codigo_dependencia`),
  CONSTRAINT `fk_imovel_dependencia_dependencia1` FOREIGN KEY (`codigo_dependencia`) REFERENCES `dependencia` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_imovel_dependencia_imovel1` FOREIGN KEY (`codigo_imovel`) REFERENCES `imovel` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipio` (
  `codigo` bigint(20) NOT NULL,
  `nome_municipio` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permissao` (
  `codigo` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proprietario`
--

DROP TABLE IF EXISTS `proprietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proprietario` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `data_cadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `senha` varchar(120) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `ativo` tinyint(1) NOT NULL DEFAULT '1',
  `data_cadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  `cpf` varchar(14) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_grupo`
--

DROP TABLE IF EXISTS `usuario_grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_grupo` (
  `codigo_usuario` bigint(20) NOT NULL,
  `codigo_grupo` bigint(20) NOT NULL,
  PRIMARY KEY (`codigo_usuario`,`codigo_grupo`),
  KEY `fk_usuario_grupo_usuario1_idx` (`codigo_usuario`),
  KEY `fk_usuario_grupo_grupo1_idx` (`codigo_grupo`),
  CONSTRAINT `fk_usuario_grupo_grupo1` FOREIGN KEY (`codigo_grupo`) REFERENCES `grupo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_grupo_usuario1` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `valor`
--

DROP TABLE IF EXISTS `valor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valor` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `valor_atual` decimal(10,2) NOT NULL,
  `sinal` decimal(10,2) DEFAULT NULL,
  `prazo_financiamento` int(11) DEFAULT NULL,
  `quitado` varchar(45) NOT NULL,
  `saldo_devedor` decimal(10,2) DEFAULT NULL,
  `org_financeira` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `valor_historico`
--

DROP TABLE IF EXISTS `valor_historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valor_historico` (
  `codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_valor` bigint(20) NOT NULL,
  `valor_alterado` decimal(10,2) DEFAULT NULL,
  `data_alteracao_valor` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`codigo`),
  KEY `fk_valor_historico_valor1_idx` (`codigo_valor`),
  CONSTRAINT `fk_valor_historico_valor1` FOREIGN KEY (`codigo_valor`) REFERENCES `valor` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-17  3:24:35

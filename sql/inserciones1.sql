-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smartfood
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` varchar(45) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Comida del Mar','2017-06-10 18:34:00');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plato` (
  `idPlato` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `img` longblob,
  `categoria` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `restaurante` int(11) NOT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`idPlato`),
  KEY `fk_Plato_Tipo1_idx` (`tipo`),
  KEY `fk_Plato_Categoria1_idx` (`categoria`),
  KEY `fk_Plato_Restaurante1_idx` (`restaurante`),
  CONSTRAINT `fk_Plato_Categoria1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plato_Restaurante1` FOREIGN KEY (`restaurante`) REFERENCES `restaurante` (`idRestaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Plato_Tipo1` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`idTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (1,'Encebollado','Rico encebollado','�\��\�\0JFIF\0\0H\0H\0\0��\0zFile source: https://commons.wikimedia.org/wiki/File:Semifinal_Encebollado_-_Guayas_y_Santa_Elena_2015_(19099321611).jpg�\�\0C\0\n\n\n		\n\Z%\Z# , #&\')*)-0-(0%()(�\�\0C\n\n\n\n(\Z\Z((((((((((((((((((((((((((((((((((((((((((((((((((��\0\0�\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\0>\0\0\0\0\0!1A\"Qa�2q#BR���b�\�\�$3CSr���4s��\�\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0�\�\03\0\0\0\0\0\0\0!1AQ\"2aq�\�#���B�\��3C��\�\0\0\0?\0?K4\�\�i���Κ�P����HD�J�4�@ǥM�T`\�J�A$\0	\'`Z+k�\�̡�	����%tYk\�@J�٬�\��\��\�2�n\�AO�V����\\\��}\�\0L\�\'j\�>��\�	kWa\�\r�V⍸dVF�`G\�U��u��k\�!ɥM�j�	f�\�g�\ZB���i�e56if�4ƣ�|\�1S\�sJ�\�\�5*\0Y�J�\00�������\0�\0:T��\0��v�-\�\��-\�y_\�4nӲ�\�\�ܼV\�\�O~��Mm\��ſ�\�@�קX\�_\�R\�|#⑾��\0*\�S�z|뤚\���\�?��8\��a�q/%Zѣ�\�vm||��Nӭ��\�C����7���$��0+r�q\��1\�HSR\�C�� YW�EW_&��T\�t�\������:㲱�k�\�E?�\�3N\rV���=诧\�0q��\�c\�t!�~\�\���\�cy��\�X\�8�oǕz,��\�\�!\n�2MrZΤ�˂JƧ\�Z\�\�i4�x\�M\��1\��\�\�El�<$ʪt(�I�s�W�$�U@� 	\�}�6�y\Z\�\�j\�\\�r�γ�8\�⑳4��p\�w76P\�٪\��x�zz\�9\�~ѣo\'4�L\�%��\�M�bj,,Ҩf�\Z\0�i�\�6iS�\�J��T1OMN(\n�G8��\'g��=\�hm�\�y;�\0!\�R\�D\�\�Ё6V��wV�4�\��\�zWQ�v^������\0��>g��\��Ck�\�5�!�T~~u,ס\�tʪ\�~\���O�\n%�\�v�Q�����^�w�M(Q�β�\�޴3䆑\"\�4�F��\r�\�ʹoX,\"@\�T<�T�nMd}B �L�L�5\�^2I\Z\�\�B=\�:R2n@�[���\Z�\�=\�쳐]�\�Cγ�]IP�i�Y�H\�xL\��n��7�qR\�\�l,d��\��3�z��(��\0\�?e�Y�Χ�c\�̺�t|\�z�#�*��{\�f�V�4a:]\�$�Ź��y*-qemt���\�υ��K�),��\�\�]:�\�3x�5m_������m��Z\�ng�$�#}ꋶ�Ӣ=��\�\"�h۟Ά4\�W�\�I����\�2y\�\�wKt�Z�6v\�>�p�7\���@(v�?啄$�����\01Z,��\�L�\Zd^9��\Z�\�/S�\��Mdt9f�\�_�\\JLṾ�z\�\�~TԖ\�7\�O��\��\��?�~\��<��\"yB�����4�8&D�|�dP.\�Y6��Yڱ˪q9�\�\��tm_5\���W�B��]�ӧɍ\Zݼ\�m���\�\�YkY\�~\��7򮿊�5sn��{\�.O2��[i;���\'�q��5\��E\�F9\�Ic<\�\�Er\�\�fDh\�\�D\r\�s�\��VV��N������\0�`恧���f���*�|\�Q�,\�\�\�R\����\Z@u]F\�r�\�!\�~��*}>�Z��G�\0_\�\�\0F\�QL�8\�a�����t��;\�$\�M^��!D6Az�yB�JG\�S��N7\�N��l\�\"E�94�D�K\"��\�9��rQYgqNO��|`s42}Q;\�\�\�.2I;(�\Z��%\�<6n5ع�4\�q\�oDl��\�nk%\�e|�����/\�\�D3>e\���]\�\�\�#���y{\n�;\�y�\�`xF\�O1��nC\�\�\�Tъ������rL61փN\�_l\��9�W�4Ew$�f�\\�q\�\�1ʱ:�nȿ,\ZZu���\�,s�_/*��	\�\�7�4.�^K����I>G#�S\�쑮\�\�$�y�\0\�g\�\�4Dkr��0\�>TSF�\�6�\�@r\�{���f\�\���)�f\�c@;[s�\�\�\�[H]I0\�9x��c�3�T�V\�<z�\�S�;rzm\�-(-p90ʷθ�[J�Ԧk{�䷺Nh7_�\�֭\�\�k\�\�.��C�;\Z1<rȦ09c��ϕY�Jw�P�e\�\�ps\�&��\�<�IG	< `�Qs\�\�9�q\�$|\rч���@�r}H��ҫ\�\�G*ϔ�7��-mH\��>Ќ/\n��]2H��у!^S�Cp��[x��7\0\�#�:/�\�\�n\��N�kkK��ix�\�\�U\���ڷ\�\�\�����L\Z�oq񇉲��V�\�\�տ\\ԖS0\'�\\5`=ER7���*dF\��vKg�3F8c�w�@��\0��Wa\�\��\0�Y\�\�d)\�G��:�\�P�W|��\���\�\�3J�\�:Ҫb	\�zkjڪ@A/�f�Q\�ߕzA�TU\0r�vF\�\�2\�\�]��/\����W;ר\���\�w\���O4\�\�f��@�O��y�E\�d{\�Piܖ;�#�\�-��ι\�k<\n\�Fp�Ώk7B\�я\�#��^�.����\�\�Z�)�1�\�ޕ�O�GQ�,��\�p䗖F�/�\'�#\n@R�\��	Й&\�lc ?\n�\�nN?!Z��G�#\�\�1�\�j�\�KЎ~\�\�߫D\�b\0�\���Յ����\�,\�(%\�@���m\��$E��\�xz\�Wc8\�FPy\�X���j{lP�%\�?�oy��3\�Y\'��%$�\���&ls��ڈB������\�� l\�5	\�uH\�>d\'��C�;�W?ۻ����\�!e_�wp�\�\��\�\\嶭~�|�w�Gu�3>ds\'�3Tk\��\0T�j\�M�\�\�͝����\�Y�\�\�\�L�\�P�\0�wߥ6��\\jv��-�\��=ⰸ\�xx�n5\�d�#^W{qs��QL\�Ƽ&M��0:W�X\�l�\�g\�O*#^\Z\\�Ef�Q�\�\�\�e\�;.|z�\���ć��Ԟ�\�\�\�8�HA\��LT����\�p������\�Z )\�\�<\�?Xܶ\�p]�r�nL\�z��bh�)Bq�\�W \��W��=HϵW\�pH۞}*\�\�	ϥUo�0:	h\�#\�y);{\�g�Ʉ�V`v{��<\�U�[3<\�M�J\��玟·�S2pJ�\"d� q,�\�z%[jJH\�\�[���=��\0�e^\�R\��BrS�WK����	\�\Z\�f��\�,�Q��퓍\�j\��\�O91�\'�\�O_\�X��K�\�S\����\�\�Trg|\�\�sX-\�b+dG&�b�\�,{Qd����BTI\�q/��\�\�\�+\�#\�*2H��7�/Rr�>�?\��dz�I�\�\�a��\���\�T5\�/ۇ��s�q9�M*<2�S#$�p\�y�J�\�X\�\�\0���\n� *�jr��X׵y�wO�z�\�\0�\�1̄ym\\�8��8\�\�z@Td\�O�\�̞N\�\�\�W.\0Q�w5�\\�;�\�ʡpc�z\�X10���.\�\�I�+c�i7\�z�$3��A.\�\�[<rGki�^�X㯿\�F\"��@\�xFx��*\�D/�o�\�lkL77Q!Q+2�\�m\�\�n�eKt/>\�;�\�D�\�w�PMa�՛�*W>uΙ]�I�*9\�l�m֠�\�/2j���~Bsj�\�0������\�w\�Zjp�y/�\�nx<!z�C�i�\�iï\�ċ2K\�r@\n=O/�k.�ڃ\��\�ib6\�\���*\�\�T�|ڮ顶;��\r\�2\�q���H����h��{�h�<�2ǧ�~.,���<Q��\�\�\�O\�\�G`~.e�\�\�(\��m�\���\�Q\�\�@�(�ax�3�\�9���c�\�&�\��3�\�tFQ!1��|`�r0(\�T�q��`�WC&�,�qZ��\�G2k4\�r$,���\�~F�\�\'ܷ��A(Äc�\�R+eVʅ\���hiq\"?rH�s�l��\�Q%��L;�r>�oB~\�u\�o\n�,K�س\�\�|W&�\�b��~>��\�;M)�\�\\�U\"3��f�BP�zT����\\�A\\}�ɑv�r�W,6�n�G`y��<$�t��I\�\����q��j\�\�Q\�Sqp\�*\�\"F\�4�������I��\�]Ma�\�Ԟ�Q\�\�\��c�V\�\�q�U\rL��\�ɚ\�:qD\�/3\�\�\'ډ�҅X��Ќ�<\�v���>\�]U���R\�ި�� �k\�;\�\�H\�<#ڔu\�+\�4[MZD�c$r(\�-�a\�?*U�\"@�QKML\�\�E6Ɏ$\"�cW\\�Hk;T\�E�A\�	\�z�\Z�d�&4\�\��D#b�xyRcO  \�\�JL��\�ެ��<b\�\�u<\�Q\�Yc�#�F�\�/T\�L%��@:`�Wp0\�\�z����t��\�Д���^o[[���OS\�\�VS�\�Xcz�X\�z�*A�B�O*��\�$a�xI\�grjJ�[�L��tW\�UwnB\�`=s]\�̯u��|NsUqe\�i\�3[\�ѯ�d\"\�鍶\�z\�c�\�\�$��R�0\�m�g�<sj�\Z��Y\�8�7M��par9bo�Ph5d�\�\��{���!�@ȍ\�\�,V�����\�zc\�\\����V۲�`\"@\��q�x�)\�o��4y-���`H\�\�& gÕ\���\\\�\�z%�\�M��\�$k)ch�� r�lls\��\�\�s�A$J\�H\��\�%�m���\0Cj\�/2����Fj�o�XG&F;d\��M��\\�\�M\���v]�ϭs\�c�ϕR�O8.i �\�\�r\�毶n�\�o�犜m��B\�Q��\�\�J�W����:,\0\�\�\����˞؎u\�%Ҿ�\0�$\�ֆ�\�gk<���	\�.\rcv  �P\�\�U�k\�h��\'�W7�v�k+<����\�\�\�zygsV\�bH�\n�6�9=r\�\���\�Y�F�\0�\�\�\�cػ\\\���g޸}\Z\�Ig�9���RN潇�Zw\�l��x\�v�5Gƽ%\�ɷ��\�\��A�D\�PMli;�w��!U����\r�>�(yI�\'?S^���~fT\�;�Q��1Z�\��z\r�T\�mJ���qm\�{�����#5��\��\�{>\�ls5�p\�\�O\�=���\Z���S^`Vjԍ@ԀJ)/\�?}\�\�Mqj�\'\�,�s\�i�:u/���7Py7\��\�-d\�/5|�[c@{G��aQ����H`\�1�U�\��\Z*In�.>|�R\�i�\�\���I�t\�|C\�爫\Z\��\'�6�\�Z\�8\�Of�\�1\�z�\�&�>!��?J�Ҍ��ɮOUMо;�\�\�,�\�OJ0$i\�bQ�\�\�q\��\0\n	m3�88w��km��-Ҩ`�]e��\��\�K�x�=mm�s������l\��\���Bq���\�Ğ~X(gct�K\�T1\�n\�*\�P�,ż>��>u\�p\��\�J\����zgւ<)gETN&\�c��ߖ\�B�7\�{�c.1S\���\���i�ǩ�+yX�\�248^3\�=<�\�\�\�0#�pq�c@�..Pab�1�#��\�8��\�$\r\'W\�*��\�|y:6��e��D.�χ|W#r\Z9J�+��#b�S0Hʥ�	�ڀ\�+\�#<�K1\�5^Osɣ��Ö14�|R/`�\�V����[|$-$�\�:(>�u�\�<�\�4��q:��\\>�(T��\�l+`oVZػʥ�\�q�g<�\�G\�.@\nI\'a�\�\�;>�5\���a:��H�e�d9d6x:h�=��sp�(�A\�k��\��PU1���D0\�r�\�\�8W\�1\�[�=2�?6y�f�W\�s,��ZE��\��\0\�ֆ��\0�:o�w<N\�\�Z�W�(7�q�k�U1�j�hb��T�ڕ<�\�\�j�5\�n\\�m\'\�N?p�~\��R��\r� �\�\�ב\\ŕ>�\�\�\�h^Z~Ǽ\�6\�vc����5��U�\��?�\���: kL��$\Z��V\�\�T�*b)\�1t\�y0؊�o�w~���\0�\�\�@���&��ͦ;\�)/0��F��OK�鈚3oq����\�Z4�\�n(\�z�j}�O\�\�x/\�?x%�b�ߦ��E�uS�\�3͵\r\Z\�\�vN(�:n+,q	�\�|8�P:t/�\�~\�x��\�\�\�\0�L��[�\�9��oM��k\�گ�Bŋ;�}�m\"fvʶ��̬\��kt\�L��&R%�J\�Yd\�\�Sᄰ\�\�CUI�ˉ��$N��\�K\�3Gݨ�\����-ȃ11�?�kh�Px\�\�45S[��Ʈ3���sD�յ\��s,	;Ӆ��\�L��	�䆯�B�|b\�@=F+��\��\�\�  Z����\�Aٻ�s/u��\�\�D!Ь\���v��/�T��\�v�\����G���\�\�c�,�\0I�oO\��\�\�-\"�c?i��\�\�ڪmcg�\���\�ֆ5㾸HW\��[��J^��>\�}�WAc\��YYZXݯy/\�a�\�(�[I \�.���[��hAF�n]�\�z��ۇ⹐�����z4�b(ĻU+[\�5�\�\�W\�\�j�Ld�Kd�5$LUhZ����yV�E��W�\�(֯AQE�TP�*����S\�ӯ�\�\�\�m\�\�\�\�)\�`\�\�\�H�\�Ye��*�1��\�ѻ5�\�\�=<�� 	\�\���l�0k\�-\�\�\�㽰�\�q\��a\�\�*�.\�\�v���/^F>�ܝ\�\�y��z]�^�\�\�����6+K\�A�\�Ej�\�\�9\�RP\"�Z���c5Jb1�\�K�o������R	���6J���\0\�5p\�6�C\�Ha�i��D�\�tުV��Ul�ˎ{�I����\0\�^2����\n�\��A\� y�>\�Y�~\��υC�^����\�j-���K�����\0B��t���p�\�/\�G�@�\�g\�c��yO�$�Uږq\�\�?y�?:\�#\�!����PK�˲O�,�S��\�2B�I���6┴�\�\�5�c�V:\�o�\�JR:�����-t�EV�U�*ժ��dZ���\\�@	F*J�J���Z��g\�\�5�/[~Q\�>)��jM��\�Y�\��~�\�\rB\�(ZPJ�lg�J�KU\�.5\�\�/o�i`�\�5袕dϪ\�MF9A��\�>U�R�^x\�\�:/	څ�\��t�\�\�J\�\�\�r��q�ǥ*U,O(G�缶�\�ve�j\� \�=iR�dĊ�*�*T��J�*b\"«aJ� @\�V@�J�`*$\nT�8�\�*T LJ�\0L���J�5�P�Z*ťJ�\�W�YJ�04F\0REx7l�no�W���Q�(�䋁��U�ک|�\�˵*T�ό�\�',1,1,1,'2017-06-10 18:50:00'),(2,'Ceviche','Ceviche','NULL',1,1,1,'2017-06-10 18:50:00');
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurante`
--

DROP TABLE IF EXISTS `restaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurante` (
  `idRestaurante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `ubicacion` varchar(150) NOT NULL,
  PRIMARY KEY (`idRestaurante`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurante`
--

LOCK TABLES `restaurante` WRITE;
/*!40000 ALTER TABLE `restaurante` DISABLE KEYS */;
INSERT INTO `restaurante` VALUES (1,'Pepe Lucho','Guayaquil');
/*!40000 ALTER TABLE `restaurante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(45) NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreTipo` varchar(45) NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Aperitivo','2017-06-10 18:50:00'),(2,'Plato Fuerte','2017-06-10 18:50:00'),(3,'Postre','2017-06-10 18:50:00');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contrasenia` varchar(45) NOT NULL,
  `rol` int(11) NOT NULL,
  `fechaRegistro` datetime NOT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `correo_UNIQUE` (`correo`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_Usuario_Rol_idx` (`rol`),
  CONSTRAINT `fk_Usuario_Rol` FOREIGN KEY (`rol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariorestaurante`
--

DROP TABLE IF EXISTS `usuariorestaurante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariorestaurante` (
  `idUsuarioRestaurante` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` int(11) NOT NULL,
  `restaurante` int(11) NOT NULL,
  PRIMARY KEY (`idUsuarioRestaurante`),
  KEY `fk_UsuarioRestaurante_Usuario1_idx` (`usuario`),
  KEY `fk_UsuarioRestaurante_Restaurante1_idx` (`restaurante`),
  CONSTRAINT `fk_UsuarioRestaurante_Restaurante1` FOREIGN KEY (`restaurante`) REFERENCES `restaurante` (`idRestaurante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioRestaurante_Usuario1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariorestaurante`
--

LOCK TABLES `usuariorestaurante` WRITE;
/*!40000 ALTER TABLE `usuariorestaurante` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariorestaurante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-11  1:56:25

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
INSERT INTO `plato` VALUES (1,'Encebollado','Rico encebollado','ÿ\Øÿ\à\0JFIF\0\0H\0H\0\0ÿş\0zFile source: https://commons.wikimedia.org/wiki/File:Semifinal_Encebollado_-_Guayas_y_Santa_Elena_2015_(19099321611).jpgÿ\Û\0C\0\n\n\n		\n\Z%\Z# , #&\')*)-0-(0%()(ÿ\Û\0C\n\n\n\n(\Z\Z((((((((((((((((((((((((((((((((((((((((((((((((((ÿÀ\0\0£\0õ\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\0>\0\0\0\0\0!1A\"Qa2q#BR‘±Áb¡\Ñ\á$3CSr’ğñ4s‚ÿ\Ä\0\Z\0\0\0\0\0\0\0\0\0\0\0\0\0ÿ\Ä\03\0\0\0\0\0\0\0!1AQ\"2aq±\Ñ#‘¡BÁ\áğ3Cñÿ\Ú\0\0\0?\0?K4\Ô\â¼iÀù¥ÎšœP€§¦³HD±J›4³@Ç¥MšT`\éJA$\0	\'`Z+k \ŞÌ¡¤	Ÿó‹ğ%tYk\Ä@JºÙ¬\ïù\íù\Õ2ön\éAî§‚OV¬¾©\\\íú}\Ã\0L\Ò\'j\Û>¨\Â	kWa\ç\rùVâ¸dVFò`G\çU¬ªuûñk\æ!É¥Mšjˆ	f˜\Óg¨\ZB˜šie56if€4Æ£š|\Ğ1S\ÔsJ€\Ò\Í5*\0Y¥J•\00§¦§¦§¦§\0ÿ\0:Tˆ¦\0ø¤v«-\á–\åø-\ây_\É4nÓ²÷\Ò\àÜ¼V\Ë\äO~¦«Mm\ßñÅ¿÷\Ô@š×§X\Ü_\ÊR\İ|#â‘¾ùÿ\0*\éS³z|ë¤š\áü³\Â?…Š8\à…aq/%ZÑ£¤\Ëvm||‘ŸNÓ­ôõ\ÌC¼Ÿ¬¬7öò³$šˆ0+rq\Û„1\ÅHSR\ŞC¥ YW†EW_&¥šT\èštü\í•õŒ•ş”:ã²±›k¹\ÒE?Š\è3N\rV’‹=è¯§\Ğ0q—š\Ôc\Ït!˜~\ã\àş†\Ícy…\ÚX\É8—oÇ•z,±\Æ\Ï!\nŠ2MrZÎ¤óË‚JÆ§Â™\ØZ\È\×i4úx\îM\åù1\Üš\Õ\ãElñ<$Êªt(ªIœs­W$U@ş 	\Æ}¨6¹y\Z\é°\Ïj\áœ\\¨rŸÎ³œ8\Îâ‘³4ù­p\éw76P\İÙª\Ï¨xˆzz\Ö9\á~Ñ£o\'4§L\à³%ƒ\é³Mšbj,,Ò¨fœ\Z\0–i‰\Å6iSó\ëJ£šT1OMN(\n•G8£ú\'g¥¼=\áhm\áy;ÿ\0!\ëR\ÑD\ï–\ÚĞ6V—³wV‘4\×—\æzWQ§v^°ú„óÿ\0–‡>g™£\ÖñCk†\Ú5Š!öT~~u,×¡\ÓtÊª\æ~\Óı¿O¸\n%\Ävñ¤Q²ƒ«–^€w¨M(QÎ²–\ÉŞ´3ä†‘\"\Ù4…FŸˆ\r‰\ßÊ¹oX,\"@\çT<¡T–nMd}B ¹L·Lô5\îŒ^2I\Z\ä\ÖB=\æ:R2n@´[ùùƒ\Z¼\è=\Õì³]‰\áCÎ³õ]IP“iòY§H\ìxL\ëšòn¸ˆ7‘qR\ï\âl,dª¼\é¥™3’zµ(òş\0\Ì?e±Y¿Î§c\ÇÌººt|\äz’#ş*º—{\îfŒV¯4a:]\Ä$™Å¹øy*-qemt·‘‘\ÈÏ…òµK§),¨¯\Ô\î]:¸\ã3xù5m_½‘£…¾ mş¯Z\çngÁ$ü#}ê‹¶ºÓ¢=ı«\Ü\"òhÛŸÎ†4\×W‹\ßI·€Œø\Ü2y\Õ\ÊwKt™Zú6v\ì>¡p÷7\ã‘ñ€@(v£?å•„$‘÷‰¿\01Z,î¢º½’\ÏL\Zd^9®ñ‘\Zò\Â/S“\Ìò¬Mdt9f\â_¤\\JLVÌ£z\ã\Ï~TÔ–\ì7\ÉOÁ\İø\àõ?ü~\Åû<„ü\"yBü¸«§–4™8&D‘|œdP.\ËY6™¢YÚ±Ëªq9ı\æ\Üştm_5\éôüW¿B—]œÓ§É\Zİ¼\âm¿µ½\ì½\ÜYkY\á~\éğ7ò®¿Šœ5sn†‹{\Ç.O2¸†[i;»ˆ\'òqŠ¯5\éóE\ÄF9\ãIc<\Õ\ÆEr\Ú\×fDh\Ó\éœD\r\Úsş\ÓúVV£¥Nµº·•ûÿ\0‘`æ§ª©f²À*|\éQ€,\â§\È\ÅR\ç®³²\Z@u]F\írŸ\à!\ê~ñı*}>šZ‰¨Gÿ\0_\Ù\İ\0F\ïQL¿8\áa²ú·¯¥t¥‰;\Ó$\ïM^®Š!D6Az¦yB½JG\áS½’N7\ÏN‚¤l\é\"E‰94…Dò¨K\"ª’\Ç9šrQYgqNO±Ÿ|`s42}Q;\î\â\×.2I;(ó¡\Z–¥%\Û<6n5Ø¹ó4\Öq\ÇoDl“ı\ãnk%\êe|±ˆúı/\á\ãD3>e\é÷û]\Ì\Ï\Ç#´§¦y{\n‘;\äœyù\Õ`xF\áO1òùnC\ß\Ó\ÈTÑŠ‡ºŠ²“ŸrL61ÖƒN\á_l\àò9¢W¤4Ew$Œf\\ñq\á\İ1Ê±:¢nÈ¿,\ZZu¢»§\á,s†_/*˜˜	\É\Ü7˜4.ñ^KÁ™¸I>G#úS\Âì‘®\å\É$’yÿ\0\Õg\ì\Ê4Dkr„†0\Ü>TSFš\Æ6ö\ã‚@r\Ü{—÷®f\Ò\áø‹)f\Ûc@;[s§\Ü\Ù\Ş[H]I0\È9x¹Œc®3øTºV\ã<zœ\ÛS¶;rzm\ä-(-p90Ê·Î¸½[J°Ô¦k{¨ä·ºNh7_Ÿ\ËÖ­\ì\Çk\Ò\è.ş®Cğ±;\Z1<rÈ¦09c‹ôÏ•YºJw™P”e\á\Íps\Ú&‡\Ş<IG	< `œQs\İ\Ì9•q\Ä$|\rÑ‡‘ª@®r}Hô¤Ò«\à¦\ã®G*Ï”¥7¹÷-mH\èô>ĞŒ/\nù]2H¬Ñƒ!^S¨Cp—‚[x¤‘7\0\Î#·:/ \ë\ïn\á‰NªkkK®•ixœ\Ç\èU\ÔôøÚ·\Ó\ß\Íˆ¯L\ZÁoqñ‡‰²§øV¨\ä\ÎÕ¿\\Ô–S0\'†\\5`=ER7©ƒ€*dF\ÎµvKg«3F8cœw€@õÿ\0´Wa\Û\Èÿ\0²Y\Ë\Õd)\ìGô®:¼\ÇP­W|’ó\çıü\Ä\Ë3J«\Î:Òªb	\èzkjÚª@A/fòQ\Óß•zAÀTU\0rƒvF\Ï\èš2\Ì\Ã]ğú/\Ù†şôW;×¨\éú¤\ßw\ËşÀO4\Ä\Óf©š@ŠO–õy¼E\ä¿d{\ÖPiÜ–;ó¦#®\Ç-‘Î¹\Õk<\n\ÑFp«Îk7B\ÖÑ\Ú#¼·^¸.Àœœš\Ã\êZ‡)ø1ü\ÍŞ•¥Oñ¤¾GQ ,¢\Åpä—–F/\'ò¢#\n@R¸\É­	Ğ™&\Ğlc ?\nœ\ïŒnN?!Z”¬G#\Â\ì1Œ\çj‹\İKĞ~\Ü\äß«D\Ìb\0ó\åóúÕ…¸›ƒ‘\ë·,\Ö(%\á@­Ÿm\êù$E„\àxz\íWc8\ã¹FPy\ìXû£§j{lP%\æ?­oyƒ¾3\íY\'»†%$Œ\îÀğ¢&lsÀªÚˆBõ°õ½\È€ l\ä5	\ÔuH\Ò>d\'™Cõ;ŒW?Û»û…½\è!e_ıwp»\ç \Åò\ç\\å¶­~º|·w‰Gu†3>ds\' 3Tk\Ğÿ\0T‹j\íMª\ã\ÛÍõş¹¥\ÛY´\İ\İ\â”L±\âP§\0’wß¥6«¦\\jv–‹-¿\ÑÁ=â°¸\ïxx—n5\ád#^W{qs«´QL\äÆ¼&M°²0:W­X\êl„\Üg\ÍO*#^\Z\\‹Ef£Q¹\î\í\îe\Ñ;.|zƒ\É²Ä‡‡‡Ô¾\Õ\Õ\Ö8‹HA\Ë§LT‹¬±¨\ÜpÁ¼ª‹¹\ÃZ )\â\Û<\ë?XÜ¶\áp]ªr›nL\Åz…¯bh¥)Bq’\ÍW \àW‹¼=HÏµW\âpHÛ}*\È\×	Ï¥UoŒ0:	hÂ\á•#\èy);{\ÑgˆÉ„V`v{‘ò<\ÅU¦[3<\×MñJ\ÙÁçŸÂ·›S2pJò\"dñ q,ó\Åz%[jJH\Ã\Ô[›¢ğ=œÿ\0³e^\îR\Ñ‡BrSúWKÀª²Ÿ	\Ü\Z\åf·‚\Ú,”QŒœí“\Íj\ìı\ïO91±\'˜\ÍO_\àX »Kö\äS\Íõ¹¾\ë¿\ÅTrg|\Õ\ÊsX-\ßb+dG&µbòŒ\é,{Qdú†šBTI\Şq/À\Õ\ç\Ò+\Ã#\Ç*2H§¬7½/Rr«>ñ?Â„\êúdz´Iˆ\î\Ğaõı\Öôõ\éT5\Ú/Û‡¼¿s†q9ò¥M*<2¼S#$ˆp\ÊyƒJ¼\ëX\á\ë’\0ˆˆ£\nª *¢jrŸªX×µy¬wOœzµ\ß\0š\Ë1Ì„ym\\¶8‘Ÿ8\ç\Óz@Td\ÙO®\ÕÌN\Ò\ä\å»W.\0Q¾w5À\\÷;µ\ãÊ¡pcŸz\î»X10òÀ®.\æ\ìI¯+cüi7\êzı$3§ŠA.\Î\Ş[<rGki•^ñ²Xã¯¿\ëF\"•ø@\âxFx²À*\âD/÷oŒ\älkL77Q!Q+2\Èm\ê\ÄnóeKt/>\Ë;½\ÄDı\ÖwÁPMa¸Õ›‹*W>uÎ™]Iü*9\álœmÖ ”\å/2jô~Bsj’\Í0Š³“·¡\Öw\í¨Zjp„y/\Ìnx<!zCüi´\ÔiÃ¯\ÖÄ‹2K\Är@\n=O/–k.¤Úƒ\É©\Úib6\Â\Ù÷¼*\í\âT’|Ú®é¡¶;Ÿ™\r\ë2\Ùqû™—H¹ˆ¼h†ª{‚h·<—2Ç§ª~.,ƒ°ò<Qˆ£\Ö\Ù\ØO\Ã\İG`~.e—\Û\æ(\Üúm­\Õı´\ëQ\ß\İ@­(„ax†3\Ó9©¤”cœ\ä§&“\Úû3š\ĞtFQ!1§|`œr0(\ä¢Tˆqªœ`†WC&™,³qZ‡–\ÌG2k4\Ör$,¾«\ä~F©\Ù\'Ü·§µA(Ã„c°\ÔR+eVÊ…\è£ô©hiq\"?rHŠs—l¾ğ\ÅQ%˜L;ñr>ôoB~\âu\ào\n«,K‡Ø³\á¨\Ç|W&˜\âb „~>ƒ„\Ñ;M)™\Ë\\–U\"3şf‹BPŒzTùı\\£A\\}§É‘v²röW,6Án•G`yõ­<$ùt¬¦I\Í\Ï„³³qƒŸj\Ñ\ìQ\îSqp\ã*\Ş\"F\Ã4²·…¯øŒI÷¥\Û]Ma\ìÔöQ\Ã\Ë\ìócúV\Ê\×q¨U\rLı¸\ãÉš\Ú:qD\å/3\Ó\í\'Ú‰ÁÒ…Xõ¢ĞŒ<\ëv·Á…>\æ]U¾¶òR\ÇŞ¨…ˆ Šk\Ù;\Û\ÙH\ä<#Ú”u\Ñ+\Õ4[MZDšc$r(\á-Áa\Ó?*U¾\"@¥QKML\Ş\éE6É$\"¨cW\\ŒHk;T\àEA\Õ	\Ëz¿\Zød­&4\Ê\í‚D#b¿xyRcO  \ã˜\éJL²õ\ÈŞ¬»€<b\â\×u<\ÇQ\éYc“#Fù\á’/T\íL%¡@:`ûWp0\Õ\éz¸¹µtñ•µ\ç·Ğ”‘ƒ^o[[®öıOS\Ò\îVS·\ÍXczX\Ãz*A¢B‚O*„\Í$a‚xI\ØgrjJ†[•L—tW\âUwnB\ç`=s]\×Ì¯uª¬|NsUqe\ßi\É3[\ÎÑ¯¼d\"\àé¶\ßz\Ëc¦\Ï\Ç$¶·R®0\Ìm²gğ­·<sj÷\Z„³Y\Ø8›7M’±par9boƒPh5d¸\ï\Öş{„‚!@È\å\È,V¤ ¢»‘\Õzc\ãŸ\\ôö·“VÛ²À`\"@\êøq€xƒ)\Üo˜4y-õ«™`H\Ñ\ä& gÃ•\ßøƒ\\\í\Ïz%°\ÕMŠ‹\È$k)chû¾ r§lls\Èò\Ü\×s£A$J\ßH\îû\×%¤mùÿ\0Cj\Û/2«ŸˆüFjºo¡XG&F;d\íòM¼•\\–\ÎM\Ô½¸v]“Ï­s\âc°Ï•R¶O8.i ¤\Ì\Ìr\Äæ¯¶n¬\Äo·çŠœmƒµB\ÖQ®’\Æ\ÓJ»W‰·‹–:,\0\è\Ç\è÷‹ğËØu\Ò%Ò¾©\0õ$\ÔÖ†\ßgk<şº‡	\å.\rcv Â øP\Î\ßUŠk\îh©¸\'øW7¯vk+<˜™Œ¹\á\Æ\äzygsV\åbH§\n¥6’9=r\è\İö¦\ïYˆFù\0¨\ß\ä\×cØ»\\\ÎgŞ¸}\Z\ÒIgş9¸™RNæ½‡³Zw\Ñl“Œx\ßvª5GÆ½%\åÉ·«’\Ó\é¶şA«D\áPMli;‹w“¯!UÀ…›„\r«>¥(yIğ\'?S^†òò~fT\É;ó­QŠ¢1Z¢\ÑÁz\r©T\ÔmJ˜´‹qm\Ä{¤±«©ô#5\ì÷\Ó{>\Öls5“p\ç\İO\æ=¨»Œ\Z»S^`VjÔ@Ô€J)/\È?}\ï\ëMqj³\'\Ò,s\Íi‡:u/÷œ7Py7\Ïù\×-d\ê/5|ø[c@{G¦®aQŸ¶£ó®¾H`\Ô1ıUÀ\æ§ş\Z*Inü.>|R\Õi•\Ğ\Ãü™I©t\Ï|C\Ëçˆ«\Z\Îş\'®6®\×Z\Ñ8\ÃOf¹\Ú1\ÌzŠ\å&·>!ƒ·?JóÒŒ«–É®OUMĞ¾; \É\èª,¤\ìOJ0$i\ÙbQ‚\ä\ìq\×ÿ\0\n	m3À88wÁÁkmŒ²-Ò¨`¥]eŒ“\Ìõ\ÍK§x—=mmòs½¼°‰¯®l\ç·ş\Åú™Bq”\æÄ~X(gctøK\ëT1\Én\Ğ*\ÊP°,Å¼>À¿>u\ê·p\Åõ\×J\à“ğ‰zgÖ‚<)gETN&\âc–ß–\ŞB´7\í{Ÿc.1S\Çƒô\äı¡i¦Ç©®+yX«\È248^3\Ï=<Š\ì\í\Ö0#‹pqc@²..Pab1„#™ù\Ñ8‡€\Æ$\r\'W\æ*—\ï|y:6¬©e—ºD.øÏ‡|W#r\Z9J¸+À#bóS0HÊ¥	ÁÚ€\Í+\Í#<ŒK1\É5^OsÉ£¤¥Ã–14Â’Š|R/`š\ÈV¶®³ô[|$-$ \å:(>¾uƒ\â<ô\Í4ğòq:•‹\\>£(T’ò\ãl+`oVZØ»Ê¥ø\åq°g<‡\éG\à´.@\nI\'a\ë¬\Ñ;>±5\âğa:ŸH¥e¯d9d6x:hï™“²=«sp (øA\êkµ‹\ÄÁPU1†™‚D0\Ûr©\å\É8W\Ç1\é[º=2¢?6y­fªW\Ïs,º˜ZEÀ›\Ìÿ\0\ÃÖ†¨ÿ\0¿:o¹w<N\Ü\ÍZ‹W’(7’q­kˆU1­jhb©TÀÚ•<ò\Î\Îj±5\èn\\‘m\'\ÕN?p~\Çñ¯Rº\r• ©\Ü\È×‘\\Å•>µ\Ú\ã\íh^Z~Ç¼\í6\ë›vc¼‘Ÿ5ü¾U‡\Òõ?ô\Ëòû:Â kL±•$\Z ŒV\Ğ\ÈT‡*b)\Å1t\Éy0ØŠ½o§w~ÿ\0ˆ\Ş\ã¥@Š­…&†‰Í¦;\Ë)/0¤şF¹ıOK‚éˆš3oq÷±Œü\ÇZ4…\àn(\Æzj}«O\Ó\ã‘x/\à?x%şbªß¦…«EªuS©\å3Íµ\r\Z\â\ÛvN(ú:n+,q	…\Î|8¯P:t/\Ç~\Îx—ù\Ğ\Ë\Í\0¶L–ª[ü\È9şoM²¾k\äÚ¯«BÅ‹;œ}œm\"fvÊ¶½¼Ì¬\éıkt\ÚL°&R%‘J\åYd\Ó\ïSá„°\é\ÂCUIøË‰§õ$N¹¼\ÆK\è3Gİ¨ö\Í¾¸‘-Èƒ11ğ?kh®Px\í\æ45S[´£Æ®3û¦ sDõÕµ\åòs,	;Ó…ô¢\ÇL›	‡ä†¯‹B½|b\Ö@=F+´ó\Ùœ\á\í  Z˜ˆ•\ÒAÙ»’s/uù–\Ï\åD!Ğ¬\âÁvù/„T±¦\Ùv\ëÁµ”Gú³ò\ä\äc·,À\0IòoO\ìı\Ä\Ü-\"ˆc?iùş\Ó\ÙÚªmcg¿\Şúš\ÚÖ†5ã¾¸HW\Èµ[«§J^ûı>\æ}ıWAc\çöYYZXİ¯y/\ßa“\ì(Š[I \ï.¹[™ªhAFŸn]¿\Ìz¥ûÛ‡â¹¹û£­z4ñ­b(Ä»U+[\Ë5½\ê…\î¬W\È\Èj”Ld’Kdó5$LUhZ¶£‚£yV®E¤‹W¢\Ó(Ö¯AQE«TP…*’Œ©S\äÓ¯„\Ğ\æ\ïm\ç\â\Õ\Ú)\â`\è\ë\ÍH¢\ÒYeˆ*ñ1“‹\ÊÑ»5­\Ã\Ú=<¸ü 	\á\Şº¥l‘0k\É-\æ¹\Ò\ïã½°\Çq\Øôa\Ô\Ô*õ.\Ï\ëv½¢³/^F>ºÜ\×\Ôy¯­z]±^¶\Ë\Şúˆ°­6+K\ÆAÁ\ÕEjø\Ê\Å9\äRP\"–Z­–µc5Jb1€\ÜK•o¼§®öòR	”ƒõ6J­’–\0\Ò5p\Ã6œC\ÍHaüiŒúD§\ÇtŞªV±²Ul•Ë{I®Ášÿ\0\İ^2ü¤©ı\nº\ß÷A\Ú y¨>\ÕY~\êşÏ…C¿^¡–°‹\íj-˜¨KşòüŸÿ\0Bƒ›tû‚—p£\ì/\áG…@ñ§\êg\Ñcø¥yO$şUÚ–q\é\Ø?y†?:\Â#\Ç!Š˜ºPK±Ë²O»,ŸS¿¸\Ø2B¾I¹¬‚6â”´\æ\ç5©c«V:\ëo©\ÎJR:½¦«Š°-t„EV¬U©*Õª´ÀdZ¹’­\\«@	F*JªJ¹õ¬Zş³g\Ù\í5¯/[~Q\Ä>) ójM¤²\ÆY©\êú~‘\İ\rB\æ(ZPJ‡lg÷J¼KU\Ô.5\Ë\é/oˆi`œ\Ö5è¢•dÏª\âMF9Aƒ¤\ê>UøR¥^x\è\É:/	Ú…½\Ôútñ\İ\ÙJ\Ğ\Ü\Är®‡qüÇ¥*U,O(Gºç¼¶\ßveŸj\Í \Û=iR¯dÄŠ**T€J•*b\"Â«aJ• @\ÅV@¥J`*$\nT¨8¦\Å*T LJ•\0LŠ¥J˜5©P„Z*Å¥J\ËW¥YJ•04F\0REx7l¯no»W¨¹šQ†(ä‹°©U¤Ú©|À\ÇËµ*T«ÏŒÿ\Ù',1,1,1,'2017-06-10 18:50:00'),(2,'Ceviche','Ceviche','NULL',1,1,1,'2017-06-10 18:50:00');
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

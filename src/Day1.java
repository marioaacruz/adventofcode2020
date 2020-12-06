
import java.util.LinkedList;

public class Day1 {

    public static void main(String[] args) {
        LinkedList<Integer> lista = createList();
        
        Integer answer = getAnswer(lista);
        
        System.out.println(answer);
    }

    private static Integer getAnswer(LinkedList<Integer> lista) {
        for(Integer i : lista) {
            LinkedList<Integer> copy = new LinkedList<Integer>();
            copy.addAll(lista);
            copy.remove(i);
            Integer r = testNumber(i, copy);
            if(r != null) {
                return r;
            }
        }
        return null;
    }

    private static Integer testNumber(Integer num, LinkedList<Integer> list) {
        for(Integer i : list) {
            LinkedList<Integer> copy = new LinkedList<Integer>();
            copy.addAll(list);
            copy.remove(i);
            Integer r = testNumberV2(num, i, copy);
            if(r != null) {
                return r;
            }
        }
        return null;
    }


    private static Integer testNumberV2(Integer num, Integer num2, LinkedList<Integer> list) {
        for(Integer i : list) {
            if(i + num + num2 == 2020) {
                System.out.println(i);
                System.out.println(num);
                System.out.println(num2);
                return i*num*num2;
            }
        }
        return null;
    }

    private static LinkedList<Integer> createList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1735);
        list.add(1700);
        list.add(1358);
        list.add(1908);
        list.add(1634);
        list.add(2006);
        list.add(762 );
        list.add(1492);
        list.add(1917);
        list.add(1591);
        list.add(1571);
        list.add(1283);
        list.add(1744);
        list.add(1815);
        list.add(1383);
        list.add(1787);
        list.add(1832);
        list.add(1032);
        list.add(1845);
        list.add(1406);
        list.add(1978);
        list.add(1263);
        list.add(1450);
        list.add(1364);
        list.add(1594);
        list.add(1877);
        list.add(1346);
        list.add(1695);
        list.add(1501);
        list.add(1266);
        list.add(1729);
        list.add(1476);
        list.add(1558);
        list.add(1684);
        list.add(1295);
        list.add(1267);
        list.add(1341);
        list.add(1415);
        list.add(1491);
        list.add(1640);
        list.add(1756);
        list.add(1330);
        list.add(1987);
        list.add(1969);
        list.add(1844);
        list.add(1706);
        list.add(1654);
        list.add(1580);
        list.add(1405);
        list.add(1419);
        list.add(1367);
        list.add(1277);
        list.add(1992);
        list.add(1953);
        list.add(1499);
        list.add(1470);
        list.add(2000);
        list.add(1739);
        list.add(1889);
        list.add(1670);
        list.add(1776);
        list.add(1798);
        list.add(1308);
        list.add(1890);
        list.add(1626);
        list.add(1284);
        list.add(1315);
        list.add(1869);
        list.add(1514);
        list.add(1214);
        list.add(1648);
        list.add(1418);
        list.add(1329);
        list.add(1795);
        list.add(1385);
        list.add(1477);
        list.add(1984);
        list.add(1796);
        list.add(1515);
        list.add(2001);
        list.add(1155);
        list.add(1800);
        list.add(1965);
        list.add(1971);
        list.add(1100);
        list.add(1650);
        list.add(1686);
        list.add(1911);
        list.add(1560);
        list.add(1912);
        list.add(1721);
        list.add(1658);
        list.add(1738);
        list.add(1885);
        list.add(1028);
        list.add(266 );
        list.add(1989);
        list.add(1704);
        list.add(1388);
        list.add(1498);
        list.add(1769);
        list.add(1453);
        list.add(925 );
        list.add(1588);
        list.add(1828);
        list.add(1024);
        list.add(1671);
        list.add(1998);
        list.add(1942);
        list.add(1636);
        list.add(1382);
        list.add(993 );
        list.add(1703);
        list.add(1475);
        list.add(1391);
        list.add(1970);
        list.add(1841);
        list.add(1952);
        list.add(1446);
        list.add(1347);
        list.add(1395);
        list.add(1440);
        list.add(1980);
        list.add(1386);
        list.add(1922);
        list.add(1857);
        list.add(1291);
        list.add(1808);
        list.add(1335);
        list.add(1876);
        list.add(1576);
        list.add(1436);
        list.add(634 );
        list.add(1557);
        list.add(1782);
        list.add(1881);
        list.add(1955);
        list.add(1765);
        list.add(1736);
        list.add(1585);
        list.add(1858);
        list.add(1862);
        list.add(989 );
        list.add(1661);
        list.add(1757);
        list.add(1775);
        list.add(1693);
        list.add(1842);
        list.add(1660);
        list.add(1647);
        list.add(870 );
        list.add(1928);
        list.add(1597);
        list.add(1420);
        list.add(1646);
        list.add(1821);
        list.add(2009);
        list.add(1866);
        list.add(1947);
        list.add(1593);
        list.add(1788);
        list.add(1369);
        list.add(1525);
        list.add(1256);
        list.add(1846);
        list.add(1445);
        list.add(1907);
        list.add(1750);
        list.add(1906);
        list.add(1849);
        list.add(765 );
        list.add(1342);
        list.add(1811);
        list.add(1260);
        list.add(1466);
        list.add(1424);
        list.add(1823);
        list.add(1767);
        list.add(1290);
        list.add(1840);
        list.add(1825);
        list.add(1287);
        list.add(1384);
        list.add(1996);
        list.add(1627);
        list.add(1983);
        list.add(1328);
        list.add(1674);
        list.add(1676);
        list.add(1727);
        list.add(1810);
        list.add(1394);
        list.add(799 );
        list.add(1723);
        list.add(1293);
        list.add(1273);
        list.add(1317);
        list.add(1749);
        list.add(1552);
        list.add(1645);
        return list;
    }
    
    

}

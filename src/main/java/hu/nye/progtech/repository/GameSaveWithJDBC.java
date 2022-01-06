package hu.nye.progtech.repository;

import hu.nye.progtech.model.Mezo;
import hu.nye.progtech.model.Pozicio;
import hu.nye.progtech.model.Stat;
import hu.nye.progtech.entity.Tabla;

import java.sql.*;


public class GameSaveWithJDBC implements GameSaveRepoForJDBC, AutoCloseable {

    private Connection con;


    private static final String INSERT_STATEMENT = "insert into game_save (jatekostabla,sajatloves,aitabla) values(?,?,?)";
    private static final String SELECT_STATEMENT = "select * from game_save";
    private static final String DELETE_STATEMENT = "delete from game_save";

    public GameSaveWithJDBC(Connection con) {
        this.con = con;
    }


    public void save(Tabla jatekosTabla, Tabla sajatLoves, Tabla aiTabla) {
        try (PreparedStatement ps = con.prepareStatement(INSERT_STATEMENT)) {
            ps.setString(1, tablaToString(jatekosTabla));
            ps.setString(2, tablaToString(sajatLoves));
            ps.setString(3, tablaToString(aiTabla));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public void delete() {
        try {
            PreparedStatement st = con.prepareStatement(DELETE_STATEMENT);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Tabla loadTabla(String tablaNev) {

        Mezo[][] mezoTomb = new Mezo[10][10];
        Tabla result = new Tabla();
        System.out.println(tablaNev);
        try (PreparedStatement ps = con.prepareStatement(SELECT_STATEMENT)) {


            ResultSet rs = ps.executeQuery();

            rs.next();
            if (rs.getRow() == 0) return null;
            System.out.println(rs);
            String map = rs.getString(tablaNev);
            String[] tomb = map.split("-");
            int c = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    Mezo mezo = new Mezo();
                    if (tomb[c].charAt(0) == '1') {
                        mezo.setSzabad(true);
                    } else {
                        mezo.setSzabad(false);
                    }
                    if (tomb[c].charAt(1) == '1') {
                        mezo.setLovesHelye(true);
                    } else {
                        mezo.setLovesHelye(false);
                    }
                    if (tomb[c].charAt(2) == '1') {
                        mezo.setTalalt();
                    }
                    mezo.setPozicio(new Pozicio(i, j));
                    mezoTomb[i][j] = mezo;
                    c++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        result.setJatekTer(mezoTomb);

        return result;
    }

    @Override
    public Stat loadStat() {
        return null;
    }

    @Override
    public void close() throws Exception {
        con.close();
    }

    private String tablaToString(Tabla tabla) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tabla.getMezo(i, j).isSzabad()) {
                    result.append("1");
                } else {
                    result.append("0");
                }
                if (tabla.getMezo(i, j).isLovesHelye()) {
                    result.append("1");
                } else {
                    result.append("0");
                }
                if (tabla.getMezo(i, j).isTalalat()) {
                    result.append("1");
                } else {
                    result.append("0");
                }
                result.append("-");
            }
        }

        return result.toString();
    }

}

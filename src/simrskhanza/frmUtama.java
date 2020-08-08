package simrskhanza;

import fungsi.DaftarMenu;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import keuangan.KeuanganHutangToko;
import keuangan.KeuanganBayarPesanToko;
import model.Toko;
import setting.DlgPenelusuranLogin;
import setting.DlgSetHargaToko;
import setting.DlgUser;
import setting.WindowInputPassword;
import toko.TokoBarang;
import toko.TokoBayarPiutang;
import toko.TokoInputStok;
import toko.TokoJenis;
import toko.TokoMember;
import toko.TokoPembelian;
import toko.TokoPemesanan;
import toko.TokoPendapatanHarian;
import toko.TokoPenjualanHarian;
import toko.TokoPengajuanBarang;
import toko.TokoPenjualan;
import toko.TokoPiutang;
import toko.TokoPiutangHarian;
import toko.TokoReturBeli;
import toko.TokoRiwayatBarang;
import toko.TokoSuplier;
import toko.TokoSuratPemesanan;

/**
 *
 * @author rsui
 */
public class frmUtama extends javax.swing.JFrame {

    public static String IDTOKO;
    private final Connection koneksi = koneksiDB.condb();
    private final sekuel Sequel = new sekuel();
    private final validasi Valid = new validasi();
    private final DlgAbout About = new DlgAbout(this, false);
    private static frmUtama myInstance;
    private PreparedStatement ps;
    private ResultSet rs;
    private final Properties prop = new Properties();
    private int jmlmenu = 0, grid = 0, tinggi = 0, i = 0, menuawal = 0;
    private String coder_nik = "", pilihpage = "", judulform = "",
            tampilkantni = Sequel.cariIsi("select tampilkan_tni_polri from set_tni_polri"),
            AKTIFKANTRACKSQL = koneksiDB.AKTIFKANTRACKSQL();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMMM-yyyy");
    private int stat = 0;

    /**
     * Creates new form frmUtama
     */
    private frmUtama() {
        super();
        initComponents();
//        initKhanza();
        visibleMenu(false);
//        hargaiAku();
        this.setExtendedState(MAXIMIZED_BOTH);
        setIconImage(new ImageIcon(super.getClass().getResource("/picture/rsuiha24.png")).getImage());

//        this.setSize(screen.width, screen.height);
        // desktop.setPreferredSize(new Dimension(800,1000));
        // desktop.setAutoscrolls(true);
        edAdmin.setDocument(new batasInput((byte) 100).getKata(edAdmin));
        edPwd.setDocument(new batasInput((byte) 100).getKata(edPwd));
        DlgLogin.setSize(319, 191);
        DlgLogin.setVisible(false);
        DlgLogin.setLocationRelativeTo(null);

        lblTgl.setText(sdf.format(new Date()));
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
        } catch (Exception e) {
            System.out.println("Notif Setting : " + e);
        }

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            LblIP.setText("" + inetAddress.getHostAddress());
        } catch (Exception e) {
            System.out.println("Notif IP : " + e);
        }

        FlayMenu.setVisible(false);
        TCari.setVisible(false);
        if (koneksiDB.CARICEPAT().equals("aktif")) {
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        isTampil();
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        isTampil();
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        isTampil();
                    }
                }
            });
        }

        try {
            if (prop.getProperty("MENUTRANSPARAN").equals("yes")) {
                DlgHome.setOpacity(0.77f);
                DlgLogin.setOpacity(0.77f);
            }
        } catch (Exception e) {
        }
    }

    /**
     *
     * @return
     */
    public static frmUtama getInstance() {
        if (myInstance == null) {
            myInstance = new frmUtama();
        }

        return myInstance;
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        setToolbar();
    }
    // private DlgMenu menu=new DlgMenu(this,false);
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        DlgLogin = new javax.swing.JDialog();
        internalFrame2 = new widget.InternalFrame();
        internalFrame3 = new widget.InternalFrame();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edAdmin = new widget.PasswordBox();
        edPwd = new widget.PasswordBox();
        jLabel6 = new javax.swing.JLabel();
        BtnLogin = new widget.Button();
        BtnCancel = new widget.Button();
        DlgHome = new javax.swing.JDialog();
        panelMenu = new widget.InternalFrame();
        panelisi2 = new widget.panelisi();
        label36 = new widget.Label();
        button1 = new widget.Button();
        label35 = new widget.Label();
        TCari = new widget.TextBox();
        ChkInput = new widget.CekBox();
        scrollPane2 = new widget.ScrollPane();
        Panelmenu = new widget.panelGlass();
        internalFrame4 = new widget.InternalFrame();
        lblStts = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUser = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTgl = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        LblIP = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        PanelUtama = new javax.swing.JPanel();
        scrollPane1 = new widget.ScrollPane();
        PanelWall = new usu.widget.glass.PanelGlass();
        FlayMenu = new usu.widget.glass.PanelGlass();
        internalFrame1 = new widget.InternalFrame();
        jPanel1 = new javax.swing.JPanel();
        BtnReturSuplier = new widget.ButtonBig();
        BtnPiutangHarian = new widget.ButtonBig();
        BtnSetHarga = new widget.ButtonBig();
        BtnBarang = new widget.ButtonBig();
        BtnJenisBarang = new widget.ButtonBig();
        BtnStokOpname = new widget.ButtonBig();
        BtnPengajuanBarang = new widget.ButtonBig();
        BtnMember = new widget.ButtonBig();
        BtnBayarPesan = new widget.ButtonBig();
        BtnPenjualan = new widget.ButtonBig();
        BtnPiutang = new widget.ButtonBig();
        BtnSetUser = new widget.ButtonBig();
        BtnBayarPiutang = new widget.ButtonBig();
        BtnHutang = new widget.ButtonBig();
        BtnSuplier = new widget.ButtonBig();
        BtnPenjualanHarian = new widget.ButtonBig();
        BtnRiwayatBarang = new widget.ButtonBig();
        BtnPendapatanHarian = new widget.ButtonBig();
        BtnSuratPemesanan = new widget.ButtonBig();
        BtnPengadaanBarang = new widget.ButtonBig();
        BtnPenerimaanBarang = new widget.ButtonBig();
        BtnLog = new widget.ButtonBig();
        BtnClose = new widget.ButtonBig();
        panelJudul = new usu.widget.glass.PanelGlass();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        MenuBar = new widget.MenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnLogin = new javax.swing.JMenuItem();
        MnGantiPassword = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        menuItemTrack = new javax.swing.JMenuItem();
        MenuKeluar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        DlgLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgLogin.setName("DlgLogin"); // NOI18N
        DlgLogin.setUndecorated(true);
        DlgLogin.setResizable(false);

        internalFrame2.setBorder(null);
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setWarnaAtas(new java.awt.Color(245, 0, 117));
        internalFrame2.setWarnaBawah(new java.awt.Color(225, 0, 97));
        internalFrame2.setLayout(null);

        internalFrame3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 125, 90), 1, true), ":: Silahkan Anda Login ::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame3.setName("internalFrame3"); // NOI18N
        internalFrame3.setRequestFocusEnabled(false);
        internalFrame3.setWarnaAtas(new java.awt.Color(255, 205, 205));
        internalFrame3.setWarnaBawah(new java.awt.Color(255, 245, 245));
        internalFrame3.setLayout(null);

        panelGlass1.setBackground(java.awt.Color.red);
        panelGlass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(145, 205, 115)));
        panelGlass1.setOpaqueImage(false);
        panelGlass1.setRound(false);
        panelGlass1.setWarna(new java.awt.Color(180, 255, 170));
        panelGlass1.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(50, 50, 50));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID Admin :");
        jLabel4.setName("jLabel4"); // NOI18N
        panelGlass1.add(jLabel4);
        jLabel4.setBounds(2, 12, 75, 23);

        jLabel5.setForeground(new java.awt.Color(50, 50, 50));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Password :");
        jLabel5.setName("jLabel5"); // NOI18N
        panelGlass1.add(jLabel5);
        jLabel5.setBounds(2, 40, 75, 23);

        edAdmin.setForeground(new java.awt.Color(50, 50, 50));
        edAdmin.setToolTipText("Silahkan masukkan ID Admin");
        edAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edAdmin.setName("edAdmin"); // NOI18N
        edAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edAdminKeyPressed(evt);
            }
        });
        panelGlass1.add(edAdmin);
        edAdmin.setBounds(80, 12, 213, 23);

        edPwd.setForeground(new java.awt.Color(50, 50, 50));
        edPwd.setToolTipText("Silahkan masukkan password");
        edPwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edPwd.setName("edPwd"); // NOI18N
        edPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edPwdKeyPressed(evt);
            }
        });
        panelGlass1.add(edPwd);
        edPwd.setBounds(80, 40, 213, 23);

        internalFrame3.add(panelGlass1);
        panelGlass1.setBounds(-1, 30, 342, 76);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/LaST (Cobalt) Lock n Gear.png"))); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        internalFrame3.add(jLabel6);
        jLabel6.setBounds(105, 5, 135, 145);

        BtnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/lock.png"))); // NOI18N
        BtnLogin.setMnemonic('Z');
        BtnLogin.setText("Log-in");
        BtnLogin.setToolTipText("Alt+Z");
        BtnLogin.setGlassColor(new java.awt.Color(235, 255, 245));
        BtnLogin.setName("BtnLogin"); // NOI18N
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });
        internalFrame3.add(BtnLogin);
        BtnLogin.setBounds(12, 115, 105, 32);

        BtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnCancel.setMnemonic('Y');
        BtnCancel.setText("Batal");
        BtnCancel.setToolTipText("Alt+Y");
        BtnCancel.setGlassColor(new java.awt.Color(235, 255, 245));
        BtnCancel.setName("BtnCancel"); // NOI18N
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });
        internalFrame3.add(BtnCancel);
        BtnCancel.setBounds(197, 115, 105, 32);

        internalFrame2.add(internalFrame3);
        internalFrame3.setBounds(2, 15, 315, 160);

        DlgLogin.getContentPane().add(internalFrame2, java.awt.BorderLayout.CENTER);

        DlgHome.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgHome.setAlwaysOnTop(true);
        DlgHome.setIconImage(null);
        DlgHome.setName("DlgHome"); // NOI18N
        DlgHome.setUndecorated(true);
        DlgHome.setResizable(false);

        panelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 235, 215)), "::[ Menu Utama ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        panelMenu.setName("panelMenu"); // NOI18N
        panelMenu.setPreferredSize(new java.awt.Dimension(2412, 3653));
        panelMenu.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 250, 228)));
        panelisi2.setName("panelisi2"); // NOI18N
        panelisi2.setPreferredSize(new java.awt.Dimension(100, 40));
        panelisi2.setWarnaBawah(new java.awt.Color(255, 255, 254));
        panelisi2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 7));

        label36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label36.setName("label36"); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(1, 23));
        panelisi2.add(label36);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        button1.setGlassColor(new java.awt.Color(255, 255, 255));
        button1.setMinimumSize(new java.awt.Dimension(28, 23));
        button1.setName("button1"); // NOI18N
        button1.setPreferredSize(new java.awt.Dimension(25, 23));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelisi2.add(button1);

        label35.setText("Tampilkan Menu :");
        label35.setName("label35"); // NOI18N
        label35.setPreferredSize(new java.awt.Dimension(105, 23));
        panelisi2.add(label35);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(470, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi2.add(TCari);

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('I');
        ChkInput.setSelected(true);
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setOpaque(false);
        ChkInput.setPreferredSize(new java.awt.Dimension(25, 23));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        panelisi2.add(ChkInput);

        panelMenu.add(panelisi2, java.awt.BorderLayout.PAGE_START);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 250, 228)));
        scrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setName("scrollPane2"); // NOI18N

        Panelmenu.setBorder(null);
        Panelmenu.setMinimumSize(new java.awt.Dimension(1975, 2826));
        Panelmenu.setName("Panelmenu"); // NOI18N
        Panelmenu.setLayout(new java.awt.GridLayout(0, 12));
        scrollPane2.setViewportView(Panelmenu);

        panelMenu.add(scrollPane2, java.awt.BorderLayout.CENTER);

        DlgHome.getContentPane().add(panelMenu, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::[ Khanza SIMKES 2020 ]::");
        setBackground(new java.awt.Color(255, 254, 254));
        setIconImages(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame4.setBackground(new java.awt.Color(235, 215, 195));
        internalFrame4.setBorder(null);
        internalFrame4.setName("internalFrame4"); // NOI18N
        internalFrame4.setPreferredSize(new java.awt.Dimension(330, 25));
        internalFrame4.setWarnaAtas(new java.awt.Color(255, 205, 210));
        internalFrame4.setWarnaBawah(new java.awt.Color(255, 245, 250));
        internalFrame4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 1));

        lblStts.setForeground(new java.awt.Color(50, 50, 50));
        lblStts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStts.setText("Status Admin :");
        lblStts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblStts.setName("lblStts"); // NOI18N
        lblStts.setPreferredSize(new java.awt.Dimension(100, 23));
        internalFrame4.add(lblStts);

        jSeparator1.setBackground(new java.awt.Color(235, 0, 107));
        jSeparator1.setForeground(new java.awt.Color(235, 0, 107));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 130, 80)));
        jSeparator1.setName("jSeparator1"); // NOI18N
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 21));
        internalFrame4.add(jSeparator1);

        lblUser.setForeground(new java.awt.Color(50, 50, 50));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Log Out");
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblUser.setName("lblUser"); // NOI18N
        lblUser.setPreferredSize(new java.awt.Dimension(170, 23));
        internalFrame4.add(lblUser);

        jSeparator2.setBackground(new java.awt.Color(235, 0, 107));
        jSeparator2.setForeground(new java.awt.Color(235, 0, 107));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 130, 80)));
        jSeparator2.setName("jSeparator2"); // NOI18N
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 21));
        internalFrame4.add(jSeparator2);

        lblTgl.setForeground(new java.awt.Color(50, 50, 50));
        lblTgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTgl.setText("Tanggal");
        lblTgl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTgl.setName("lblTgl"); // NOI18N
        lblTgl.setPreferredSize(new java.awt.Dimension(100, 23));
        internalFrame4.add(lblTgl);

        jSeparator3.setBackground(new java.awt.Color(235, 0, 107));
        jSeparator3.setForeground(new java.awt.Color(235, 0, 107));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 130, 80)));
        jSeparator3.setName("jSeparator3"); // NOI18N
        jSeparator3.setOpaque(true);
        jSeparator3.setPreferredSize(new java.awt.Dimension(1, 21));
        internalFrame4.add(jSeparator3);

        LblIP.setForeground(new java.awt.Color(50, 50, 50));
        LblIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblIP.setText("Alamat IP");
        LblIP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LblIP.setName("LblIP"); // NOI18N
        LblIP.setPreferredSize(new java.awt.Dimension(120, 23));
        internalFrame4.add(LblIP);

        jSeparator6.setBackground(new java.awt.Color(235, 0, 107));
        jSeparator6.setForeground(new java.awt.Color(235, 0, 107));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 130, 80)));
        jSeparator6.setName("jSeparator6"); // NOI18N
        jSeparator6.setOpaque(true);
        jSeparator6.setPreferredSize(new java.awt.Dimension(1, 21));
        internalFrame4.add(jSeparator6);

        jLabel7.setForeground(new java.awt.Color(50, 50, 50));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/file-edit-16x16.png"))); // NOI18N
        jLabel7.setText(" Didesain & dibuat oleh Khanza.Soft Media");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setIconTextGap(3);
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(287, 23));
        internalFrame4.add(jLabel7);

        PanelUtama.setName("PanelUtama"); // NOI18N
        PanelUtama.setOpaque(false);

        scrollPane1.setBorder(null);
        scrollPane1.setName("scrollPane1"); // NOI18N

        PanelWall.setBackground(new java.awt.Color(29, 29, 29));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/wallpaper.jpg"))); // NOI18N
        PanelWall.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
        PanelWall.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall.setRound(false);
        PanelWall.setWarna(new java.awt.Color(110, 110, 110));
        PanelWall.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelWallMouseMoved(evt);
            }
        });

        FlayMenu.setBackground(new java.awt.Color(255, 255, 255));
        FlayMenu.setOpaqueImage(false);
        FlayMenu.setPreferredSize(new java.awt.Dimension(200, 110));
        FlayMenu.setRound(false);
        FlayMenu.setLayout(new java.awt.GridLayout(1, 0, 4, 5));

        internalFrame1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setOpaque(false);
        internalFrame1.setPreferredSize(new java.awt.Dimension(50, 120));
        internalFrame1.setVerifyInputWhenFocusTarget(false);
        internalFrame1.setWarnaAtas(new java.awt.Color(255, 245, 245));
        internalFrame1.setWarnaBawah(new java.awt.Color(255, 205, 205));
        internalFrame1.setLayout(new java.awt.BorderLayout());

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        BtnReturSuplier.setBackground(new java.awt.Color(255, 255, 255));
        BtnReturSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_lock__payment__pay__security_2542006.png"))); // NOI18N
        BtnReturSuplier.setMnemonic('L');
        BtnReturSuplier.setText("Retur Ke Suplier");
        BtnReturSuplier.setToolTipText("Alt+L");
        BtnReturSuplier.setIconTextGap(2);
        BtnReturSuplier.setName("BtnReturSuplier"); // NOI18N
        BtnReturSuplier.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnReturSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReturSuplierActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 3, 0, 0);
        jPanel1.add(BtnReturSuplier, gridBagConstraints);

        BtnPiutangHarian.setBackground(new java.awt.Color(255, 255, 255));
        BtnPiutangHarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_ecommerce-21_4707177.png"))); // NOI18N
        BtnPiutangHarian.setMnemonic('L');
        BtnPiutangHarian.setText("Piutang Harian");
        BtnPiutangHarian.setToolTipText("Alt+L");
        BtnPiutangHarian.setIconTextGap(2);
        BtnPiutangHarian.setName("BtnPiutangHarian"); // NOI18N
        BtnPiutangHarian.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPiutangHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPiutangHarianActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 3, 0, 0);
        jPanel1.add(BtnPiutangHarian, gridBagConstraints);

        BtnSetHarga.setBackground(new java.awt.Color(255, 255, 255));
        BtnSetHarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_edit-copy_118918.png"))); // NOI18N
        BtnSetHarga.setMnemonic('L');
        BtnSetHarga.setText("Set Harga");
        BtnSetHarga.setToolTipText("Alt+L");
        BtnSetHarga.setIconTextGap(2);
        BtnSetHarga.setName("BtnSetHarga"); // NOI18N
        BtnSetHarga.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnSetHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSetHargaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel1.add(BtnSetHarga, gridBagConstraints);

        BtnBarang.setBackground(new java.awt.Color(255, 255, 255));
        BtnBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_gifts_sale_shop_4177581.png"))); // NOI18N
        BtnBarang.setMnemonic('L');
        BtnBarang.setText("Barang");
        BtnBarang.setToolTipText("Alt+L");
        BtnBarang.setIconTextGap(2);
        BtnBarang.setName("BtnBarang"); // NOI18N
        BtnBarang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBarangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel1.add(BtnBarang, gridBagConstraints);

        BtnJenisBarang.setBackground(new java.awt.Color(255, 255, 255));
        BtnJenisBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cabinet.png"))); // NOI18N
        BtnJenisBarang.setMnemonic('L');
        BtnJenisBarang.setText("Jenis Barang");
        BtnJenisBarang.setToolTipText("Alt+L");
        BtnJenisBarang.setIconTextGap(2);
        BtnJenisBarang.setName("BtnJenisBarang"); // NOI18N
        BtnJenisBarang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnJenisBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJenisBarangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(BtnJenisBarang, gridBagConstraints);

        BtnStokOpname.setBackground(new java.awt.Color(255, 255, 255));
        BtnStokOpname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/ark2.png"))); // NOI18N
        BtnStokOpname.setMnemonic('L');
        BtnStokOpname.setText("Stok Opname");
        BtnStokOpname.setToolTipText("Alt+L");
        BtnStokOpname.setIconTextGap(2);
        BtnStokOpname.setName("BtnStokOpname"); // NOI18N
        BtnStokOpname.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnStokOpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnStokOpnameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(BtnStokOpname, gridBagConstraints);

        BtnPengajuanBarang.setBackground(new java.awt.Color(255, 255, 255));
        BtnPengajuanBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnPengajuanBarang.setMnemonic('L');
        BtnPengajuanBarang.setText("Pengajuan Barang");
        BtnPengajuanBarang.setToolTipText("Alt+L");
        BtnPengajuanBarang.setIconTextGap(2);
        BtnPengajuanBarang.setName("BtnPengajuanBarang"); // NOI18N
        BtnPengajuanBarang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPengajuanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPengajuanBarangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 3, 0, 0);
        jPanel1.add(BtnPengajuanBarang, gridBagConstraints);

        BtnMember.setBackground(new java.awt.Color(255, 255, 255));
        BtnMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_lock__payment__pay__security_2542006.png"))); // NOI18N
        BtnMember.setMnemonic('L');
        BtnMember.setText("Member");
        BtnMember.setToolTipText("Alt+L");
        BtnMember.setIconTextGap(2);
        BtnMember.setName("BtnMember"); // NOI18N
        BtnMember.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMemberActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(BtnMember, gridBagConstraints);

        BtnBayarPesan.setBackground(new java.awt.Color(255, 255, 255));
        BtnBayarPesan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/gaji.png"))); // NOI18N
        BtnBayarPesan.setMnemonic('L');
        BtnBayarPesan.setText("Bayar Pesan");
        BtnBayarPesan.setToolTipText("Alt+L");
        BtnBayarPesan.setIconTextGap(2);
        BtnBayarPesan.setName("BtnBayarPesan"); // NOI18N
        BtnBayarPesan.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnBayarPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBayarPesanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 0, 0);
        jPanel1.add(BtnBayarPesan, gridBagConstraints);

        BtnPenjualan.setBackground(new java.awt.Color(255, 255, 255));
        BtnPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_lock__payment__pay__security_2542006.png"))); // NOI18N
        BtnPenjualan.setMnemonic('L');
        BtnPenjualan.setText("Penjualan");
        BtnPenjualan.setToolTipText("Alt+L");
        BtnPenjualan.setIconTextGap(2);
        BtnPenjualan.setName("BtnPenjualan"); // NOI18N
        BtnPenjualan.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPenjualanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 17, 0, 0);
        jPanel1.add(BtnPenjualan, gridBagConstraints);

        BtnPiutang.setBackground(new java.awt.Color(255, 255, 255));
        BtnPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_lock__payment__pay__security_2542006.png"))); // NOI18N
        BtnPiutang.setMnemonic('L');
        BtnPiutang.setText("Piutang");
        BtnPiutang.setToolTipText("Alt+L");
        BtnPiutang.setIconTextGap(2);
        BtnPiutang.setName("BtnPiutang"); // NOI18N
        BtnPiutang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPiutangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 2);
        jPanel1.add(BtnPiutang, gridBagConstraints);

        BtnSetUser.setBackground(new java.awt.Color(255, 255, 255));
        BtnSetUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_edit-copy_118918.png"))); // NOI18N
        BtnSetUser.setMnemonic('L');
        BtnSetUser.setText("Set User");
        BtnSetUser.setToolTipText("Alt+L");
        BtnSetUser.setIconTextGap(2);
        BtnSetUser.setName("BtnSetUser"); // NOI18N
        BtnSetUser.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnSetUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSetUserActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 67;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 2);
        jPanel1.add(BtnSetUser, gridBagConstraints);

        BtnBayarPiutang.setBackground(new java.awt.Color(255, 255, 255));
        BtnBayarPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/bantuan.png"))); // NOI18N
        BtnBayarPiutang.setMnemonic('L');
        BtnBayarPiutang.setText("Bayar Piutang");
        BtnBayarPiutang.setToolTipText("Alt+L");
        BtnBayarPiutang.setIconTextGap(2);
        BtnBayarPiutang.setName("BtnBayarPiutang"); // NOI18N
        BtnBayarPiutang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnBayarPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBayarPiutangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 3, 0, 0);
        jPanel1.add(BtnBayarPiutang, gridBagConstraints);

        BtnHutang.setBackground(new java.awt.Color(255, 255, 255));
        BtnHutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_checkout_47678.png"))); // NOI18N
        BtnHutang.setMnemonic('L');
        BtnHutang.setText("Hutang");
        BtnHutang.setToolTipText("Alt+L");
        BtnHutang.setIconTextGap(2);
        BtnHutang.setName("BtnHutang"); // NOI18N
        BtnHutang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnHutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHutangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 0, 0);
        jPanel1.add(BtnHutang, gridBagConstraints);

        BtnSuplier.setBackground(new java.awt.Color(255, 255, 255));
        BtnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/if_kde-folder-public_25193.png"))); // NOI18N
        BtnSuplier.setMnemonic('L');
        BtnSuplier.setText("Suplier");
        BtnSuplier.setToolTipText("Alt+L");
        BtnSuplier.setIconTextGap(2);
        BtnSuplier.setName("BtnSuplier"); // NOI18N
        BtnSuplier.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSuplierActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(BtnSuplier, gridBagConstraints);

        BtnPenjualanHarian.setBackground(new java.awt.Color(255, 255, 255));
        BtnPenjualanHarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_edit-copy_118918.png"))); // NOI18N
        BtnPenjualanHarian.setMnemonic('L');
        BtnPenjualanHarian.setText("Penjualan Harian");
        BtnPenjualanHarian.setToolTipText("Alt+L");
        BtnPenjualanHarian.setIconTextGap(2);
        BtnPenjualanHarian.setName("BtnPenjualanHarian"); // NOI18N
        BtnPenjualanHarian.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPenjualanHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPenjualanHarianActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 14, 0, 0);
        jPanel1.add(BtnPenjualanHarian, gridBagConstraints);

        BtnRiwayatBarang.setBackground(new java.awt.Color(255, 255, 255));
        BtnRiwayatBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_ecommerce-21_4707177.png"))); // NOI18N
        BtnRiwayatBarang.setMnemonic('L');
        BtnRiwayatBarang.setText("Riwayat Barang");
        BtnRiwayatBarang.setToolTipText("Alt+L");
        BtnRiwayatBarang.setIconTextGap(2);
        BtnRiwayatBarang.setName("BtnRiwayatBarang"); // NOI18N
        BtnRiwayatBarang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnRiwayatBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRiwayatBarangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 0);
        jPanel1.add(BtnRiwayatBarang, gridBagConstraints);

        BtnPendapatanHarian.setBackground(new java.awt.Color(255, 255, 255));
        BtnPendapatanHarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_lock__payment__pay__security_2542006.png"))); // NOI18N
        BtnPendapatanHarian.setMnemonic('L');
        BtnPendapatanHarian.setText("Pendapatan Harian");
        BtnPendapatanHarian.setToolTipText("Alt+L");
        BtnPendapatanHarian.setIconTextGap(2);
        BtnPendapatanHarian.setName("BtnPendapatanHarian"); // NOI18N
        BtnPendapatanHarian.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPendapatanHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPendapatanHarianActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 3, 0, 0);
        jPanel1.add(BtnPendapatanHarian, gridBagConstraints);

        BtnSuratPemesanan.setBackground(new java.awt.Color(255, 255, 255));
        BtnSuratPemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_edit-copy_118918.png"))); // NOI18N
        BtnSuratPemesanan.setMnemonic('L');
        BtnSuratPemesanan.setText("Surat Pemesanan");
        BtnSuratPemesanan.setToolTipText("Alt+L");
        BtnSuratPemesanan.setIconTextGap(2);
        BtnSuratPemesanan.setName("BtnSuratPemesanan"); // NOI18N
        BtnSuratPemesanan.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnSuratPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSuratPemesananActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel1.add(BtnSuratPemesanan, gridBagConstraints);

        BtnPengadaanBarang.setBackground(new java.awt.Color(255, 255, 255));
        BtnPengadaanBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_edit-copy_118918.png"))); // NOI18N
        BtnPengadaanBarang.setMnemonic('L');
        BtnPengadaanBarang.setText("Pengadaan Barang");
        BtnPengadaanBarang.setToolTipText("Alt+L");
        BtnPengadaanBarang.setIconTextGap(2);
        BtnPengadaanBarang.setName("BtnPengadaanBarang"); // NOI18N
        BtnPengadaanBarang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPengadaanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPengadaanBarangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 0, 0);
        jPanel1.add(BtnPengadaanBarang, gridBagConstraints);

        BtnPenerimaanBarang.setBackground(new java.awt.Color(255, 255, 255));
        BtnPenerimaanBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/iconfinder_edit-copy_118918.png"))); // NOI18N
        BtnPenerimaanBarang.setMnemonic('L');
        BtnPenerimaanBarang.setText("Penerimaan Barang");
        BtnPenerimaanBarang.setToolTipText("Alt+L");
        BtnPenerimaanBarang.setIconTextGap(2);
        BtnPenerimaanBarang.setName("BtnPenerimaanBarang"); // NOI18N
        BtnPenerimaanBarang.setPreferredSize(new java.awt.Dimension(130, 40));
        BtnPenerimaanBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPenerimaanBarangActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 3, 0, 0);
        jPanel1.add(BtnPenerimaanBarang, gridBagConstraints);

        BtnLog.setBackground(new java.awt.Color(255, 255, 255));
        BtnLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/login2.png"))); // NOI18N
        BtnLog.setMnemonic('L');
        BtnLog.setText("Log In");
        BtnLog.setToolTipText("Alt+L");
        BtnLog.setIconTextGap(2);
        BtnLog.setName("BtnLog"); // NOI18N
        BtnLog.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 14, 74, 0);
        jPanel1.add(BtnLog, gridBagConstraints);

        BtnClose.setBackground(new java.awt.Color(255, 255, 255));
        BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Delete.png"))); // NOI18N
        BtnClose.setMnemonic('U');
        BtnClose.setText("Keluar");
        BtnClose.setToolTipText("Alt+U");
        BtnClose.setIconTextGap(2);
        BtnClose.setName("BtnClose"); // NOI18N
        BtnClose.setPreferredSize(new java.awt.Dimension(100, 40));
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 78;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 3, 74, 0);
        jPanel1.add(BtnClose, gridBagConstraints);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.CENTER);

        panelJudul.setBackground(new java.awt.Color(255, 255, 255));
        panelJudul.setOpaqueImage(false);
        panelJudul.setPreferredSize(new java.awt.Dimension(200, 170));
        panelJudul.setRound(false);
        panelJudul.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(50, 50, 50));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Your Businis Solution");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setName("jLabel11"); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(430, 30));
        panelJudul.add(jLabel11);
        jLabel11.setBounds(100, 60, 790, 30);

        jLabel8.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486142_shopping_cart.png"))); // NOI18N
        jLabel8.setText(" Khanza HMS+, Hospital Management System");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel8.setName("jLabel8"); // NOI18N
        panelJudul.add(jLabel8);
        jLabel8.setBounds(40, -70, 1040, 220);

        javax.swing.GroupLayout PanelWallLayout = new javax.swing.GroupLayout(PanelWall);
        PanelWall.setLayout(PanelWallLayout);
        PanelWallLayout.setHorizontalGroup(
            PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelWallLayout.createSequentialGroup()
                .addGroup(PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FlayMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelWallLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(internalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGap(15, 15, 15))
            .addGroup(PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelWallLayout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 1220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelWallLayout.setVerticalGroup(
            PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelWallLayout.createSequentialGroup()
                .addComponent(internalFrame1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FlayMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
            .addGroup(PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelWallLayout.createSequentialGroup()
                    .addContainerGap(587, Short.MAX_VALUE)
                    .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        scrollPane1.setViewportView(PanelWall);

        javax.swing.GroupLayout PanelUtamaLayout = new javax.swing.GroupLayout(PanelUtama);
        PanelUtama.setLayout(PanelUtamaLayout);
        PanelUtamaLayout.setHorizontalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
        );
        PanelUtamaLayout.setVerticalGroup(
            PanelUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
        );

        MenuBar.setBackground(new java.awt.Color(255, 255, 254));
        MenuBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuBar.setForeground(new java.awt.Color(255, 255, 255));
        MenuBar.setName("MenuBar"); // NOI18N
        MenuBar.setPreferredSize(new java.awt.Dimension(227, 26));

        jMenu1.setBackground(new java.awt.Color(20, 0, 20));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/85.png"))); // NOI18N
        jMenu1.setMnemonic('A');
        jMenu1.setText("Program");
        jMenu1.setToolTipText("Alt+A");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu1.setName("jMenu1"); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(80, 26));

        MnLogin.setBackground(new java.awt.Color(255, 255, 254));
        MnLogin.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnLogin.setForeground(new java.awt.Color(50, 90, 40));
        MnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/login2.png"))); // NOI18N
        MnLogin.setText("Log In");
        MnLogin.setName("MnLogin"); // NOI18N
        MnLogin.setPreferredSize(new java.awt.Dimension(170, 30));
        MnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogActionPerformed(evt);
            }
        });
        jMenu1.add(MnLogin);

        MnGantiPassword.setBackground(new java.awt.Color(255, 255, 254));
        MnGantiPassword.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnGantiPassword.setForeground(new java.awt.Color(50, 90, 40));
        MnGantiPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/unlock.png"))); // NOI18N
        MnGantiPassword.setText("Ubah Password");
        MnGantiPassword.setEnabled(false);
        MnGantiPassword.setName("MnGantiPassword"); // NOI18N
        MnGantiPassword.setPreferredSize(new java.awt.Dimension(170, 30));
        MnGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnGantiPasswordBtnLogActionPerformed(evt);
            }
        });
        jMenu1.add(MnGantiPassword);

        jSeparator14.setBackground(new java.awt.Color(190, 220, 180));
        jSeparator14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 220, 180)));
        jSeparator14.setForeground(new java.awt.Color(190, 220, 180));
        jSeparator14.setName("jSeparator14"); // NOI18N
        jSeparator14.setPreferredSize(new java.awt.Dimension(0, 1));
        jMenu1.add(jSeparator14);

        menuItemTrack.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        menuItemTrack.setText("Track SQL");
        menuItemTrack.setEnabled(false);
        menuItemTrack.setName("menuItemTrack"); // NOI18N
        menuItemTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTrackActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemTrack);

        MenuKeluar.setBackground(new java.awt.Color(255, 255, 254));
        MenuKeluar.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MenuKeluar.setForeground(new java.awt.Color(50, 90, 40));
        MenuKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Delete.png"))); // NOI18N
        MenuKeluar.setText("Keluar");
        MenuKeluar.setName("MenuKeluar"); // NOI18N
        MenuKeluar.setPreferredSize(new java.awt.Dimension(170, 30));
        MenuKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });
        jMenu1.add(MenuKeluar);

        MenuBar.add(jMenu1);

        jMenu4.setBackground(new java.awt.Color(20, 0, 20));
        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/63.png"))); // NOI18N
        jMenu4.setMnemonic('G');
        jMenu4.setText("Tentang Program");
        jMenu4.setToolTipText("Alt+G");
        jMenu4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu4.setName("jMenu4"); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(121, 26));
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        MenuBar.add(jMenu4);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(internalFrame4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(internalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPenjualanActionPerformed
        // TODO add your handling code here:
        btnPenjualanTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnPenjualanActionPerformed

    private void BtnSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSuplierActionPerformed
        // TODO add your handling code here:
        btnSuplierTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnSuplierActionPerformed

    private void BtnJenisBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJenisBarangActionPerformed
        // TODO add your handling code here:
        btnJenisTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnJenisBarangActionPerformed

    private void BtnStokOpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnStokOpnameActionPerformed
        // TODO add your handling code here:
        btnStokOpnameTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnStokOpnameActionPerformed

    private void BtnRiwayatBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRiwayatBarangActionPerformed
        // TODO add your handling code here:
        btnRiwayatBarangTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnRiwayatBarangActionPerformed

    private void BtnPenjualanHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPenjualanHarianActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPenjualanHarian form = new TokoPenjualanHarian(null, false);
//        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
//        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPenjualanHarianActionPerformed

    private void BtnBayarPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBayarPiutangActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoBayarPiutang form = new TokoBayarPiutang(null, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
//        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnBayarPiutangActionPerformed

    private void BtnPendapatanHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPendapatanHarianActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPendapatanHarian form = new TokoPendapatanHarian(null, false);
//        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
//        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPendapatanHarianActionPerformed

    private void BtnReturSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReturSuplierActionPerformed
        // TODO add your handling code here:
        btnReturKeSuplierTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnReturSuplierActionPerformed

    private void BtnPiutangHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPiutangHarianActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPiutangHarian form = new TokoPiutangHarian(null, false);
//        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
//        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPiutangHarianActionPerformed

    private void BtnPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPiutangActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPiutang form = new TokoPiutang(null, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
//        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPiutangActionPerformed

    private void BtnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMemberActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoMember form = new TokoMember(null, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
//        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnMemberActionPerformed

    private void BtnBayarPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBayarPesanActionPerformed
        // TODO add your handling code here:
        btnBayarPesanTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnBayarPesanActionPerformed

    private void BtnHutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHutangActionPerformed
        // TODO add your handling code here:
        btnHutangTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnHutangActionPerformed

    private void BtnPengadaanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPengadaanBarangActionPerformed
        // TODO add your handling code here:
        btnPengadaanBarangTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnPengadaanBarangActionPerformed

    private void BtnPenerimaanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPenerimaanBarangActionPerformed
        // TODO add your handling code here:
        btnPenerimaanBarangTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnPenerimaanBarangActionPerformed

    private void BtnPengajuanBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPengajuanBarangActionPerformed
        // TODO add your handling code here:
        btnPengajuanBarangTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnPengajuanBarangActionPerformed

    private void BtnSuratPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSuratPemesananActionPerformed
        // TODO add your handling code here:
        btnSuratPemesananTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnSuratPemesananActionPerformed

    private void BtnSetHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSetHargaActionPerformed
        // TODO add your handling code here:
        btnSetHargaTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnSetHargaActionPerformed

    private void BtnBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBarangActionPerformed
        // TODO add your handling code here:
        btnBarangTokoActionPerformed(evt);
    }//GEN-LAST:event_BtnBarangActionPerformed

    private void BtnSetUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSetUserActionPerformed
        // TODO add your handling code here:
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgUser form = new DlgUser(this, false);
        form.emptTeks();
//        form.onCari();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnSetUserActionPerformed

    private void menuItemTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTrackActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPenelusuranLogin rbpoli = new DlgPenelusuranLogin(this, false);
        rbpoli.isCek();
        rbpoli.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rbpoli.setLocationRelativeTo(PanelUtama);
        rbpoli.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_menuItemTrackActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosed
        DlgHome.dispose();
        System.exit(0);
    }// GEN-LAST:event_formWindowClosed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnCloseActionPerformed
        isTutup();
        DlgHome.dispose();
        int jawab = JOptionPane.showConfirmDialog(null, "Yakin anda mau keluar dari program ini ????", "Konfirmasi",
                JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }// GEN-LAST:event_BtnCloseActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {
        edAdmin.setText("");
        edPwd.setText("");
        DlgLogin.dispose();
    }

    private void BtnLogActionPerformed(java.awt.event.ActionEvent evt) {
        FlayMenu.setVisible(false);

        switch (BtnLog.getText().trim()) {
            case "Log Out":
                MnGantiPassword.setEnabled(false);
                menuItemTrack.setEnabled(false);
                edAdmin.setText("");
                edPwd.setText("");
                BtnLog.setText("Log In");
                MnLogin.setText("Log In");
                lblStts.setText("Status Admin : ");
                lblUser.setText("Log Out");
                visibleMenu(false);
                stat = 0;
                BtnLog.setText("Log In");
                DaftarMenu.TPENJUALAN = "";
                DaftarMenu.TSUPLIER = "";
                DaftarMenu.TJENIS_BARANG_TOKO = "";
                DaftarMenu.TSTOK_OPNAME = "";
                DaftarMenu.TRIWAYAT_BARANG = "";
                DaftarMenu.TMEMBER = "";
                DaftarMenu.TPENJUALAN_HARIAN = "";
                DaftarMenu.TPIUTANG_HARIAN = "";
                DaftarMenu.TBAYAR_PIUTANG = "";
                DaftarMenu.TPENDAPATAN_HARIAN = "";
                DaftarMenu.TRETUR_SUPLIER = "";
                DaftarMenu.TPIUTANG_TOKO = "";
                DaftarMenu.TBAYAR_PESANAN = "";
                DaftarMenu.THUTANG = "";
                DaftarMenu.TPENGADAAN_BARANG = "";
                DaftarMenu.TPENERIMAAN_BARANG = "";
                DaftarMenu.TPENGAJUAN_BARANG = "";
                DaftarMenu.TSURAT_PEMESANAN = "";
                DaftarMenu.TSET_HARGA = "";
                DaftarMenu.TUSER = "";
                Toko.nip = "";
                Toko.setNip("");
                isTutup();
                break;
            case "Log In":
                DlgLogin.setVisible(true);
                edAdmin.requestFocus();
                break;
        }
    }

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {
//        String versi = Sequel.cariIsi("select version from version_control");
        if (edAdmin.getText().trim().equals("")) {
            Valid.textKosong(edAdmin, "ID User");
        } else if (edPwd.getText().trim().equals("")) {
            Valid.textKosong(edPwd, "Password");
        } else {
            try {
                cekUser();
                IDTOKO = Sequel.cariIsi("Select id_toko from set_toko where id=0");
                if (AKTIFKANTRACKSQL.equals("yes")) {
                    Sequel.menyimpan("tracker", "'Admin Utama',current_date(),current_time()", "Login");
                }
                if (IDTOKO.trim().equals("")) {
                    IDTOKO = "";
                }
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
            }
        }
    }

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenu4MouseClicked
        isTutup();
        About.setSize(PanelWall.getWidth(), PanelWall.getHeight());
        About.setLocationRelativeTo(PanelWall);
        About.setVisible(true);
        DlgHome.dispose();
    }// GEN-LAST:event_jMenu4MouseClicked

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {// GEN-FIRST:event_jMenu4MenuSelected
        isTutup();
        About.setSize(PanelWall.getWidth(), PanelWall.getHeight());
        About.setLocationRelativeTo(PanelWall);
        About.setVisible(true);
        DlgHome.dispose();
    }// GEN-LAST:event_jMenu4MenuSelected

    private void edAdminKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_edAdminKeyPressed
        Valid.pindah(evt, BtnCancel, edPwd);
    }// GEN-LAST:event_edAdminKeyPressed

    private void edPwdKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_edPwdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnLoginActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            edAdmin.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            BtnLogin.requestFocus();
        }
    }// GEN-LAST:event_edPwdKeyPressed

    private void BtnMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnMenuActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgHome.setSize(PanelUtama.getWidth() - 30, PanelUtama.getHeight() - 30);
        DlgHome.setLocationRelativeTo(PanelUtama);
        DlgHome.setVisible(true);
        if (menuawal == 0) {
            setLayout();
            menuawal = 1;
        } else {
            isTampil();
        }
        this.setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_BtnMenuActionPerformed
//
//    private void BtnToolKasirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BtnToolKasirActionPerformed
//        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
//        isTutup();
//        kasirralan.isCek();
//        kasirralan.setCariKosong();
//        kasirralan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
//        kasirralan.setLocationRelativeTo(PanelUtama);
//        kasirralan.setVisible(true);
//        DlgHome.dispose();
//        this.setCursor(Cursor.getDefaultCursor());
//    }// GEN-LAST:event_BtnToolKasirActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowStateChanged
        if (this.getState() == 1) {
            isTutup();
        }
    }// GEN-LAST:event_formWindowStateChanged

    private void MnGantiPasswordBtnLogActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MnGantiPasswordBtnLogActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        WindowInputPassword barcode = new WindowInputPassword(this, true);
        barcode.SetUserPass(lblUser.getText(), edPwd.getText());
        barcode.setLocationRelativeTo(PanelUtama);
        barcode.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());

    }// GEN-LAST:event_MnGantiPasswordBtnLogActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_button1ActionPerformed
        DlgHome.dispose();
    }// GEN-LAST:event_button1ActionPerformed

    private void cmbMenuItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_cmbMenuItemStateChanged
        isTampil();
    }// GEN-LAST:event_cmbMenuItemStateChanged

    private void MnBelumDatang1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MnBelumDatang1ActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Valid.panggilUrl("presensi");
        this.setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_MnBelumDatang1ActionPerformed

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentMoved
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.setLocationRelativeTo(PanelUtama);
                win.toFront();
            }
        }

        setToolbar();
    }// GEN-LAST:event_formComponentMoved

    private void PanelWallMouseMoved(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_PanelWallMouseMoved
        setToolbar();
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.setLocationRelativeTo(PanelUtama);
                win.toFront();
            }
        }

    }// GEN-LAST:event_PanelWallMouseMoved

    private void MnInfoBedActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MnInfoBedActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Valid.panggilUrl("bed3.php");
        this.setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_MnInfoBedActionPerformed

    private void MnInfoBed1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MnInfoBed1ActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Valid.panggilUrl("jadwaldokter2.php");
        this.setCursor(Cursor.getDefaultCursor());
    }// GEN-LAST:event_MnInfoBed1ActionPerformed

    private void MnInfoBed2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MnInfoBed2ActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Valid.panggilUrl("bed4.php");
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {
        TCari.setVisible(true);
        TCari.requestFocus();
        isTampil();
    }// GEN-LAST:event_ChkInputActionPerformed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_TCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            isTampil();
        }
    }// GEN-LAST:event_TCariKeyPressed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgUser user = new DlgUser(this, false);
        user.emptTeks();
        user.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        user.setLocationRelativeTo(PanelUtama);
        user.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnSuplierTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoSuplier suplier = new TokoSuplier(this, false);
        suplier.isCek();
        suplier.emptTeks();
        suplier.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        suplier.setLocationRelativeTo(PanelUtama);
        suplier.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnJenisTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoJenis aplikasi = new TokoJenis(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnSetHargaTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetHargaToko aplikasi = new DlgSetHargaToko(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnBarangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoBarang form = new TokoBarang(this, false);
        form.emptTeks();
        form.onCari();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPiutangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPiutang form = new TokoPiutang(null, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnReturKeSuplierTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoReturBeli form = new TokoReturBeli(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPendapatanHarianTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPendapatanHarian form = new TokoPendapatanHarian(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnBayarPiutangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoBayarPiutang bayarpiutang = new TokoBayarPiutang(this, false);
        bayarpiutang.tampil();
        bayarpiutang.emptTeks();
        bayarpiutang.isCek();
        bayarpiutang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bayarpiutang.setLocationRelativeTo(PanelUtama);
        bayarpiutang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPiutangHarianTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPiutangHarian form = new TokoPiutangHarian(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPenjualanHarianTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPenjualanHarian form = new TokoPenjualanHarian(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnStokOpnameTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoInputStok opname = new TokoInputStok(this, false);
        opname.tampil();
        opname.isCek();
        opname.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        opname.setLocationRelativeTo(PanelUtama);
        opname.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnRiwayatBarangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoRiwayatBarang sirkulasi = new TokoRiwayatBarang(this, false);
        sirkulasi.isCek();
        sirkulasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        sirkulasi.setLocationRelativeTo(PanelUtama);
        sirkulasi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnSuratPemesananTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoSuratPemesanan form = new TokoSuratPemesanan(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPengajuanBarangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPengajuanBarang form = new TokoPengajuanBarang(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPenerimaanBarangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPemesanan pembelian = new TokoPemesanan(this, false);
        pembelian.isCek();
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnHutangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        KeuanganHutangToko form = new KeuanganHutangToko(this, false);
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnBayarPesanTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        KeuanganBayarPesanToko bayarpesan = new KeuanganBayarPesanToko(this, false);
        bayarpesan.tampil();
        bayarpesan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bayarpesan.setLocationRelativeTo(PanelUtama);
        bayarpesan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnMemberTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoMember form = new TokoMember(null, false);
        form.emptTeks();
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPengadaanBarangTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPembelian pembelian = new TokoPembelian(this, false);
        pembelian.isCek();
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void btnPenjualanTokoActionPerformed(java.awt.event.ActionEvent evt) {
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        TokoPenjualan form = new TokoPenjualan(null, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmUtama().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.ButtonBig BtnBarang;
    private widget.ButtonBig BtnBayarPesan;
    private widget.ButtonBig BtnBayarPiutang;
    private widget.Button BtnCancel;
    private widget.ButtonBig BtnClose;
    private widget.ButtonBig BtnHutang;
    private widget.ButtonBig BtnJenisBarang;
    private widget.ButtonBig BtnLog;
    private widget.Button BtnLogin;
    private widget.ButtonBig BtnMember;
    private widget.ButtonBig BtnPendapatanHarian;
    private widget.ButtonBig BtnPenerimaanBarang;
    private widget.ButtonBig BtnPengadaanBarang;
    private widget.ButtonBig BtnPengajuanBarang;
    private widget.ButtonBig BtnPenjualan;
    private widget.ButtonBig BtnPenjualanHarian;
    private widget.ButtonBig BtnPiutang;
    private widget.ButtonBig BtnPiutangHarian;
    private widget.ButtonBig BtnReturSuplier;
    private widget.ButtonBig BtnRiwayatBarang;
    private widget.ButtonBig BtnSetHarga;
    private widget.ButtonBig BtnSetUser;
    private widget.ButtonBig BtnStokOpname;
    private widget.ButtonBig BtnSuplier;
    private widget.ButtonBig BtnSuratPemesanan;
    private widget.CekBox ChkInput;
    private javax.swing.JDialog DlgHome;
    private javax.swing.JDialog DlgLogin;
    private usu.widget.glass.PanelGlass FlayMenu;
    private javax.swing.JLabel LblIP;
    private widget.MenuBar MenuBar;
    private javax.swing.JMenuItem MenuKeluar;
    private javax.swing.JMenuItem MnGantiPassword;
    private javax.swing.JMenuItem MnLogin;
    private javax.swing.JPanel PanelUtama;
    private usu.widget.glass.PanelGlass PanelWall;
    private widget.panelGlass Panelmenu;
    private widget.TextBox TCari;
    private widget.Button button1;
    private widget.PasswordBox edAdmin;
    private widget.PasswordBox edPwd;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.InternalFrame internalFrame4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private widget.Label label35;
    private widget.Label label36;
    private javax.swing.JLabel lblStts;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenuItem menuItemTrack;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelJudul;
    private widget.InternalFrame panelMenu;
    private widget.panelisi panelisi2;
    private widget.ScrollPane scrollPane1;
    private widget.ScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables

    public void isWall() {
        String versi = "BETA";
        try {
            ps = koneksi.prepareStatement(
                    "select nama_instansi, alamat_instansi, kabupaten, propinsi, aktifkan, wallpaper,kontak,email,logo from setting");
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    jLabel8.setText(rs.getString(1));
                    this.setTitle(".:: SIM " + rs.getString("nama_instansi") + " Versi " + versi + " ::.");
                    jLabel11.setText(rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + " ");
                    Toko.setNamars(rs.getString("nama_instansi"));
                    Toko.setAlamatrs(rs.getString("alamat_instansi"));
                    Toko.setKabupatenrs(rs.getString("kabupaten"));
                    Toko.setPropinsirs(rs.getString("propinsi"));
                    Toko.setKontakrs(rs.getString("kontak"));
                    Toko.setEmailrs(rs.getString("email"));
                    if (rs.getString(5).equals("Yes")) {
                        Blob blob = rs.getBlob(6);
                        PanelWall
                                .setBackgroundImage(new javax.swing.ImageIcon(blob.getBytes(1, (int) (blob.length()))));
                        repaint();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : Silahkan Set Aplikasi " + e);
        }
    }

    private void isTutup() {
        FlayMenu.setVisible(false);
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.dispose();
            }
        }
    }

    private void setToolbar() {
//        if (internalFrame1.getWidth() < (BtnMenu.getWidth() + BtnLog.getWidth() + BtnClose.getWidth() + 8)) {
//            internalFrame1.setSize(new Dimension(PanelUtama.getWidth(), 90));
//        } else {
//            internalFrame1.setSize(new Dimension(PanelUtama.getWidth(), 90));
//        }
    }

    /**
     *
     */
    public void isTampil() {
        Panelmenu.removeAll();

        if (TCari.getText().equals("")) {
//            isCariKosong();
        } else if (!TCari.getText().equals("")) {
//            isCariIsi();
        }

        setLayout();
    }

    private void setLayout() {
        if (jmlmenu <= 1) {
            grid = 1;
        } else if (jmlmenu <= 4) {
            grid = 2;
        } else if (jmlmenu <= 9) {
            grid = 3;
        } else if (jmlmenu <= 16) {
            grid = 4;
        } else if (jmlmenu > 16) {
            grid = 5;
        }

        if (jmlmenu <= 20) {
            tinggi = scrollPane2.getHeight() - 5;
        } else if (jmlmenu <= 25) {
            tinggi = scrollPane2.getHeight() + (scrollPane2.getHeight() / 4);
        } else if (jmlmenu > 25) {
            tinggi = 1;
            for (i = 25; i < jmlmenu; i++) {
                if (i % 5 == 0) {
                    tinggi++;
                }
            }
            tinggi = scrollPane2.getHeight() + ((scrollPane2.getHeight() / 4) * tinggi);
        }

        Panelmenu.setLayout(new GridLayout(0, grid));
        Panelmenu.setPreferredSize(new Dimension(scrollPane2.getWidth() - 10, tinggi));
        Panelmenu.revalidate();
        Panelmenu.repaint();
    }
    
    private void cekUser() {
        if (BtnLog.getText().equals("Log In")) {
            try {
                ps = koneksi.prepareStatement("select * from petugas inner join user on petugas.nip=user.nip "
                        + "where petugas.user=? and petugas.pass = ?");
                try {
                    ps.setString(1, edAdmin.getText().trim());
                    ps.setString(2, edPwd.getText().trim());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        stat = 1;
                        if (rs.getString("id_module").equals(DaftarMenu.PENJUALAN)) {
                            BtnPenjualan.setEnabled(true);
                            DaftarMenu.TPENJUALAN = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.SUPLIER)) {
                            BtnSuplier.setEnabled(true);
                            DaftarMenu.TSUPLIER = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.JENIS_BARANG_TOKO)) {
                            BtnJenisBarang.setEnabled(true);
                            DaftarMenu.TJENIS_BARANG_TOKO = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.AKUN_PENAGIHAN_PIUTANG)) {
//                            BtnAk.setEnabled(true);
                            DaftarMenu.TAKUN_PENAGIHAN_PIUTANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.STOK_OPNAME)) {
                            BtnStokOpname.setEnabled(true);
                            DaftarMenu.TSTOK_OPNAME = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.RIWAYAT_BARANG)) {
                            BtnRiwayatBarang.setEnabled(true);
                            DaftarMenu.TRIWAYAT_BARANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.MEMBER)) {
                            BtnMember.setEnabled(true);
                            DaftarMenu.TMEMBER = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.TOKO_JENIS)) {
//                            BtnJenis.setEnabled(true);
                            DaftarMenu.TTOKO_JENIS = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PENJUALAN_HARIAN)) {
                            BtnPenjualanHarian.setEnabled(true);
                            DaftarMenu.TPENJUALAN_HARIAN = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PIUTANG_HARIAN)) {
                            BtnPiutangHarian.setEnabled(true);
                            DaftarMenu.TPIUTANG_HARIAN = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.BAYAR_PIUTANG)) {
                            BtnBayarPiutang.setEnabled(true);
                            DaftarMenu.TBAYAR_PIUTANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PENDAPATAN_HARIAN)) {
                            BtnPendapatanHarian.setEnabled(true);
                            DaftarMenu.TPENDAPATAN_HARIAN = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.RETUR_SUPLIER)) {
                            BtnReturSuplier.setEnabled(true);
                            DaftarMenu.TRETUR_SUPLIER = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PIUTANG_TOKO)) {
                            BtnPiutang.setEnabled(true);
                            DaftarMenu.TPIUTANG_TOKO = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.BAYAR_PESANAN)) {
                            BtnBayarPesan.setEnabled(true);
                            DaftarMenu.TBAYAR_PESANAN = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.HUTANG)) {
                            BtnHutang.setEnabled(true);
                            DaftarMenu.THUTANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PENGADAAN_BARANG)) {
                            BtnPengadaanBarang.setEnabled(true);
                            DaftarMenu.TPENGADAAN_BARANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PENERIMAAN_BARANG)) {
                            BtnPenerimaanBarang.setEnabled(true);
                            DaftarMenu.TPENERIMAAN_BARANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PENGAJUAN_BARANG)) {
                            BtnPengajuanBarang.setEnabled(true);
                            DaftarMenu.TPENGAJUAN_BARANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.SURAT_PEMESANAN)) {
                            BtnSuratPemesanan.setEnabled(true);
                            DaftarMenu.TSURAT_PEMESANAN = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.BARANG)) {
                            BtnBarang.setEnabled(true);
                            DaftarMenu.TBARANG = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.SET_HARGA)) {
                            BtnSetHarga.setEnabled(true);
                            DaftarMenu.TSET_HARGA = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.USER)) {
                            BtnSetUser.setEnabled(true);
                            DaftarMenu.TUSER = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.PETUGAS)) {
//                            BtnPetu.setEnabled(true);
                            DaftarMenu.TPETUGAS = rs.getString("id_module");
                        }
                        if (rs.getString("id_module").equals(DaftarMenu.ADMIN_UTAMA)) {
                            visibleMenu(true);
                            DaftarMenu.TADMIN_UTAMA = rs.getString("id_module");
                        }
                        MnGantiPassword.setEnabled(false);
                        menuItemTrack.setEnabled(true);

                        DlgLogin.dispose();
                        BtnLog.setText("Log Out");
                        MnLogin.setText("Log Out");
                        lblStts.setText("Admin : ");
                        lblUser.setText(rs.getString("nama"));
                        Toko.setNip(rs.getString("nip"));

                    }
                    if (stat == 0) {
                        JOptionPane.showMessageDialog(rootPane, "Login Gagal, User tidak terdaftar!");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    if (rs != null) {
                        rs.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                }

            } catch (Exception e) {
                System.out.println("Notifikasi Login error : " + e);
                visibleMenu(false);
            }

        } else if (BtnLog.getText().equals("Log Out")) {
            stat = 0;
            BtnLog.setText("Log In");
            DaftarMenu.TPENJUALAN = "";
            DaftarMenu.TSUPLIER = "";
            DaftarMenu.TJENIS_BARANG_TOKO = "";
            DaftarMenu.TSTOK_OPNAME = "";
            DaftarMenu.TRIWAYAT_BARANG = "";
            DaftarMenu.TMEMBER = "";
            DaftarMenu.TPENJUALAN_HARIAN = "";
            DaftarMenu.TPIUTANG_HARIAN = "";
            DaftarMenu.TBAYAR_PIUTANG = "";
            DaftarMenu.TPENDAPATAN_HARIAN = "";
            DaftarMenu.TRETUR_SUPLIER = "";
            DaftarMenu.TPIUTANG_TOKO = "";
            DaftarMenu.TBAYAR_PESANAN = "";
            DaftarMenu.THUTANG = "";
            DaftarMenu.TPENGADAAN_BARANG = "";
            DaftarMenu.TPENERIMAAN_BARANG = "";
            DaftarMenu.TPENGAJUAN_BARANG = "";
            DaftarMenu.TSURAT_PEMESANAN = "";
            DaftarMenu.TSET_HARGA = "";
            DaftarMenu.TTOKO_JENIS = "";
            DaftarMenu.TBARANG = "";
            DaftarMenu.TUSER = "";
            DaftarMenu.TSATUAN_BARANG = "";
            DaftarMenu.TPETUGAS = "";
            Toko.nip = "";
            Toko.setNip("");
        }
    }

    private void visibleMenu(Boolean b) {
        BtnSetUser.setEnabled(b);
        BtnPenjualan.setEnabled(b);
        BtnSuplier.setEnabled(b);
        BtnJenisBarang.setEnabled(b);
        BtnStokOpname.setEnabled(b);
        BtnRiwayatBarang.setEnabled(b);
        BtnMember.setEnabled(b);
        BtnPenjualanHarian.setEnabled(b);
        BtnPiutangHarian.setEnabled(b);
        BtnBayarPiutang.setEnabled(b);
        BtnPendapatanHarian.setEnabled(b);
        BtnReturSuplier.setEnabled(b);
        BtnPiutang.setEnabled(b);
        BtnBayarPesan.setEnabled(b);
        BtnHutang.setEnabled(b);
        BtnPengadaanBarang.setEnabled(b);
        BtnPenerimaanBarang.setEnabled(b);
        BtnPengajuanBarang.setEnabled(b);
        BtnSuratPemesanan.setEnabled(b);
        BtnBarang.setEnabled(b);
        BtnSetHarga.setEnabled(b);
        BtnSetUser.setEnabled(b);
//        return b;
    }
}

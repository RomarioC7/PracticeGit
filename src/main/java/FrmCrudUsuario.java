
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmCrudUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtFechaNac;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JTextArea txtArea;
	private JPasswordField passwordClave;
	private JButton btnRegistrar, btnConsultar, btnModificar,btnEliminar,btnListado, btnGuardar;
	private static String CRUD = "M";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudUsuario frame = new FrmCrudUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(66, 11, 86, 20);
		//txtcodigo.setEditable(false);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 14, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 52, 46, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 49, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 87, 46, 14);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(66, 80, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 119, 46, 14);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(66, 116, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblFechnac = new JLabel("Fech.Nac");
		lblFechnac.setBounds(10, 153, 46, 14);
		contentPane.add(lblFechnac);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(66, 150, 86, 20);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 183, 46, 14);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(66, 180, 86, 20);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(162, 119, 46, 14);
		contentPane.add(lblClave);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(162, 183, 46, 14);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(218, 180, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro();
			}
		});
		btnRegistrar.setBounds(304, 14, 89, 23);
		contentPane.add(btnRegistrar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Consultar();
			}
		});
		btnConsultar.setBounds(304, 48, 89, 23);
		contentPane.add(btnConsultar);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoxParam();
			}
		});
		btnListado.setBounds(304, 83, 89, 23);
		contentPane.add(btnListado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 213, 401, 101);
		contentPane.add(scrollPane);
		
		txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		passwordClave = new JPasswordField();
		passwordClave.setBounds(218, 117, 86, 17);
		contentPane.add(passwordClave);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modificar();
			}
		});
		btnModificar.setBounds(304, 115, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eliminar();
			}
		});
		btnEliminar.setBounds(304, 149, 89, 23);
		contentPane.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Guardar();
			}
		});
		btnGuardar.setBounds(162, 10, 89, 23);
		contentPane.add(btnGuardar);
		HabilitarBtn(true);
		btnGuardar.setEnabled(false);
	}
	
	 protected void Eliminar() {
		 HabilitarBtn(false);
		 btnGuardar.setEnabled(true);	
		 Consultar();
		 CRUD ="E";
	}

	protected void Guardar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		if(CRUD == "M"){
			Usuario u = ModifOrRegistrar();			
			try{
				em.getTransaction().begin();
				em.merge(u);
				em.getTransaction().commit();
				
				JOptionPane.showMessageDialog(this, "Usuario Modificado");
				}catch(Exception ex){
					JOptionPane.showMessageDialog(this, "Error al Modificar: " +ex.getMessage());
				}finally{		
				    Limpiar();
					em.close();
				}
		}else{
			if(CRUD == "I"){
				Usuario u = ModifOrRegistrar();			
				try{
					em.getTransaction().begin();
					em.persist(u);
					em.getTransaction().commit();
					
					JOptionPane.showMessageDialog(this, "Usuario Registrado");
					}catch(Exception ex){
						JOptionPane.showMessageDialog(this, "Error al Registrado: " +ex.getMessage());
					}finally{		
					    Limpiar();
						em.close();
					}
			}else{
				if(CRUD == "E"){					
					int codigo = Integer.parseInt(txtcodigo.getText());
					try{
						int r = em.createNamedQuery("Usuario.DeleteRow", Usuario.class)
								.setParameter("parmCodigo", codigo).executeUpdate();
						if(r ==1){
						JOptionPane.showMessageDialog(this, "Usuario Eliminado");
						}
						}catch(Exception ex){
							JOptionPane.showMessageDialog(this, "Error al Eliminar: " +ex.getMessage());
						}finally{		
						    Limpiar();
							em.close();
						}
				}
			}
		}
		HabilitarBtn(true);
	}
	public Usuario ModifOrRegistrar(){
		int codigo = 0;
		if (CRUD == "M"){
		codigo = Integer.parseInt(txtcodigo.getText());
		}
		
		String nombre = txtNombre.getText();
		String apellido = txtApellido.getText();
		String clave = passwordClave.getPassword().toString();
		String user = txtUsuario.getText();
		String fecha = txtFechaNac.getText();
		int estado = Integer.parseInt(txtEstado.getText());
		int tipo = Integer.parseInt(txtTipo.getText());
		Usuario u = new Usuario();
		u.setCodigo(codigo);
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setClave(clave);
		u.setFnacim(fecha);
		u.setEstado(estado);
		u.setTipo(tipo);
		u.setUsuario(user);
		return u;
	}
	protected void Modificar() {
		HabilitarBtn(false);
		btnGuardar.setEnabled(true);				
		BuscarUsuario();	
		CRUD = "M";
		 
		
	}

	void Listado(EntityManager em) { 		 
		// EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// EntityManager em = fabrica.createEntityManager();		
		// TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll", Usuario.class);
		 //List<Usuario> ListaUsu = query.getResultList();
		 List<Usuario> ListaUsu = em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();

		 for (Usuario usuario : ListaUsu) {
			 txtArea.append(usuario.getNombre() + "\t" + 
					 usuario.getApellido() + "\t" +
					 usuario.getFnacim()+ "\n");
			
		}
	}
	 void ListadoxParam() { 
		 txtArea.setText("");
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		 EntityManager em = fabrica.createEntityManager();
		 
		 List<Usuario> ListaUsu = null;
		 
		 if(txtTipo.getText().isEmpty()){			 
			 Listado(em);
			 
		 }else{
			 int tipo = Integer.parseInt(txtTipo.getText());
			 ListaUsu = em.createNamedQuery("Usuario.findAllxTipo", Usuario.class)
					.setParameter("parmtipo", tipo).getResultList();
		 }
		
		 for (Usuario usuario : ListaUsu) {
			 
			 txtArea.append(usuario.getNombre() + "\t" + 
					 usuario.getApellido() + "\t" +
					 usuario.getFnacim()+ "\n");			
		}
	}
	void Consultar(){
		BuscarUsuario();
	}
	void BuscarUsuario(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		int codigo = Integer.parseInt(txtcodigo.getText());
		Usuario usu = em.find(Usuario.class, codigo);		
		if(usu==null){
			JOptionPane.showMessageDialog(this, "Usuario desconocido");
			Limpiar();
		}else{
			txtNombre.setText(usu.getNombre());
			txtApellido.setText(usu.getApellido());
			txtFechaNac.setText(usu.getFnacim());
			txtTipo.setText(usu.getTipo()+"");
			txtEstado.setText(usu.getEstado()+"");
			passwordClave.setText(usu.getClave());
			txtFechaNac.setText(usu.getFnacim());
			txtUsuario.setText(usu.getUsuario());
			
		}
	}
	 void registro() {
		HabilitarBtn(false);
		btnGuardar.setEnabled(true);		
		CRUD = "I";
	}
	 void HabilitarBtn(boolean b){
		 btnGuardar.setEnabled(b);
		 btnRegistrar.setEnabled(b);
		 btnModificar.setEnabled(b);
		 btnListado.setEnabled(b);
		 btnConsultar.setEnabled(b);
		 btnEliminar.setEnabled(b);		
	 }
	 void Limpiar(){
		 txtcodigo.setText("");
		 txtNombre.setText("");
		 txtTipo.setText("");
		 txtFechaNac.setText("");
		 txtEstado.setText("");
		 txtTipo.setText("");
		 txtUsuario.setText("");
		 passwordClave.setText("");		 
	 }
}

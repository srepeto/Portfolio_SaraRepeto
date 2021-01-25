using System;
using System.Data;
using MySql.Data.MySqlClient;
using System.Windows.Forms;

namespace CSMySQL_SMART_CRUD_V1
{
    public partial class Form1 : Form
    {

        private string id = "";
        private int intRow = 0;
        public Form1()
        {
            InitializeComponent();
            resetMe();
        }

        private void resetMe()
        {
            this.id = "";

            firstNameTextBox.Clear();
            lastNameTextBox.Clear();

            if (genderComboBox.Items.Count > 0)
            {
                genderComboBox.SelectedIndex = 0;
            }

            updateButton.Text = "MODIFICAR";
            deleteButton.Text = "ELIMINAR";

            keywordTextBox.Clear();

            if (keywordTextBox.CanSelect)
            {
                keywordTextBox.Select();
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            loadData("");
        }


        private void execute(string mySQL, string param)
        {
            CRUD.cmd = new MySqlCommand(mySQL, CRUD.con);
            AddParameters(param);
            CRUD.PerformCRUD(CRUD.cmd);
        }

        private void AddParameters(string str)
        {
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.AddWithValue("firstName", firstNameTextBox.Text.Trim());
            CRUD.cmd.Parameters.AddWithValue("lastName", lastNameTextBox.Text.Trim());
            CRUD.cmd.Parameters.AddWithValue("gender", genderComboBox.SelectedItem.ToString());

            if (str == "Update" || str == "Delete" && !string.IsNullOrEmpty(this.id))
            {
                CRUD.cmd.Parameters.AddWithValue("id", this.id);
            }
        }


        private void loadData(string keyword)
        {

            CRUD.sql = "SELECT autoid, firstname, lastname, CONCAT(firstname, ' ', lastname) AS 'fullname', gender FROM tb_smart_crud " +
                      "WHERE CONCAT (firstname, ' ', lastname) LIKE @keyword1 OR gender = @keyword2 ORDER BY autoid ASC";

            string strKeyword = string.Format("%{0}%", keyword);

            CRUD.cmd = new MySqlCommand(CRUD.sql, CRUD.con);
            CRUD.cmd.Parameters.Clear();
            CRUD.cmd.Parameters.AddWithValue("keyword1", strKeyword);
            CRUD.cmd.Parameters.AddWithValue("keyword2", keyword);

            DataTable dt = CRUD.PerformCRUD(CRUD.cmd);

            if (dt.Rows.Count>0)
            {
                intRow = Convert.ToInt32(dt.Rows.Count.ToString());
            }
            else
            {
                intRow = 0;
            }

            toolStripStatusLabel1.Text = "Número de fila(s): " + intRow.ToString();

            DataGridView dgv1 = dataGridView1;

            dgv1.MultiSelect = false;
            dgv1.AutoGenerateColumns = true;
            dgv1.SelectionMode = DataGridViewSelectionMode.FullRowSelect;

            dgv1.DataSource = dt;
            dgv1.Columns[0].HeaderText = "ID";
            dgv1.Columns[1].HeaderText = "Nombre";
            dgv1.Columns[2].HeaderText = "Apellidos";
            dgv1.Columns[3].HeaderText = "Nombre completo";
            dgv1.Columns[4].HeaderText = "Género";

            dgv1.Columns[0].Width = 90;
            dgv1.Columns[1].Width = 200;
            dgv1.Columns[2].Width = 200;
            dgv1.Columns[3].Width = 228;
            dgv1.Columns[4].Width = 120;

        }

        private void insertButton_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(firstNameTextBox.Text.Trim()) || string.IsNullOrEmpty(lastNameTextBox.Text.Trim()))
            {
                MessageBox.Show("Por favor, introduce nombre y apellidos.", "MySQL : Inserción de datos", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }

            CRUD.sql = "INSERT INTO tb_smart_crud(firstname, lastname, gender) VALUES(@firstName, @lastName, @gender)";

            execute(CRUD.sql, "Insert");

            MessageBox.Show("¡Los datos han sido guardados!", "MySQL : Inserción de datos", MessageBoxButtons.OK, MessageBoxIcon.Information);

            loadData("");

            resetMe();
            
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex != -1)
            {
                DataGridView dgv1 = dataGridView1;

                this.id = Convert.ToString(dgv1.CurrentRow.Cells[0].Value);
                updateButton.Text = "MODIFICAR (" + this.id + ")";
                deleteButton.Text = "ELIMINAR (" + this.id + ")";

                firstNameTextBox.Text = Convert.ToString(dgv1.CurrentRow.Cells[1].Value);
                lastNameTextBox.Text = Convert.ToString(dgv1.CurrentRow.Cells[2].Value);
                // Column 3 = Full Name
                genderComboBox.SelectedItem = Convert.ToString(dgv1.CurrentRow.Cells[4].Value);
            }
        }

        private void updateButton_Click(object sender, EventArgs e)
        {
            if (dataGridView1.Rows.Count == 0)
            {
                return;
            }

            if (string.IsNullOrEmpty(this.id))
            {
                MessageBox.Show("Por favor, selecciona una registro de la tabla.", "MySQL : Modificación de datos", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }

            if (string.IsNullOrEmpty(firstNameTextBox.Text.Trim()) || string.IsNullOrEmpty(lastNameTextBox.Text.Trim()))
            {
                MessageBox.Show("Por favor, introduce nombre y apellidos.", "MySQL : Modificación de datos", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }

            CRUD.sql = "UPDATE tb_smart_crud SET firstname = @firstName, lastname = @lastName, gender = @gender WHERE autoid = @id";

            execute(CRUD.sql, "Update");

            MessageBox.Show("¡Los datos han sido modificados!", "MySQL : Modificación de datos", MessageBoxButtons.OK, MessageBoxIcon.Information);

            loadData("");

            resetMe();
        }

        private void deleteButton_Click(object sender, EventArgs e)
        {

            if (dataGridView1.Rows.Count == 0)
            {
                return;
            }

            if (string.IsNullOrEmpty(this.id))
            {
                MessageBox.Show("Por favor, selecciona una registro de la tabla.", "MySQL : Eliminación de datos", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                return;
            }

            if (MessageBox.Show("¿Quieres eliminar el registro seleccionado?", "MySQL : Eliminación de datos", 
                                MessageBoxButtons.YesNo, MessageBoxIcon.Question, MessageBoxDefaultButton.Button1) == DialogResult.Yes)
            {
                CRUD.sql = "DELETE FROM tb_smart_crud WHERE autoid = @id";

                execute(CRUD.sql, "Delete");

                MessageBox.Show("¡Los datos han sido eliminados!", "MySQL : Eliminación de datos", MessageBoxButtons.OK, MessageBoxIcon.Information);

                loadData("");

                resetMe();
            }

        }

        private void searchButton_Click(object sender, EventArgs e)
        {

            if (string.IsNullOrEmpty(keywordTextBox.Text.Trim()))
            {
                loadData("");
            }
            else
            {
                loadData(this.keywordTextBox.Text.Trim());
            }

            resetMe();
        }
    }
}


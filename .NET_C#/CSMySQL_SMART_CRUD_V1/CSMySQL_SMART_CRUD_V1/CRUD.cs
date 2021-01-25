using System;
using System.Data;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace CSMySQL_SMART_CRUD_V1
{
    class CRUD
    {
        private static string getConnectionString()
        {
            string host = "server=localhost;";
            string port = "port=3306;";
            string db = "Database=cs_smart_crud;";
            string user = "user=root;";
            string pass = "password=root";

            string conString = string.Format("{0}{1}{2}{3}{4}", host, port, db, user, pass);

            return conString;
        }

        public static MySqlConnection con = new MySqlConnection(getConnectionString());
        public static MySqlCommand cmd = default(MySqlCommand);
        public static string sql = String.Empty;

        public static DataTable PerformCRUD(MySqlCommand com)
        {
            MySqlDataAdapter da = default(MySqlDataAdapter);
            DataTable dt = new DataTable();

            try
            {
                da = new MySqlDataAdapter();
                da.SelectCommand = com;
                da.Fill(dt);

                return dt;

            }
            catch (Exception ex)
            {

                MessageBox.Show("Ha ocurrido un eror: " + ex.Message, "Error al realizar operaciones CRUD", MessageBoxButtons.OK, MessageBoxIcon.Error);
                dt = null;
            }

            return dt;
        }
    }
}

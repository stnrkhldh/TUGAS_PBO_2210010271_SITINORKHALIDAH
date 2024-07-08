 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administrasi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import gui.frameUtama;

/**
 *
 * @author acer
 */
public class koneksi {
    
   private String databaseName = "dbjasafoto";
   private String username = "root";
   private String password = "";
   private String lokasi = "jdbc:mysql://localhost/"+databaseName;
   public static Connection koneksiDB;
   
   public koneksi(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           koneksiDB = DriverManager.getConnection(lokasi,username,password);
           System.out.println("Database Terkoneksi");
       }catch (Exception e){
           System.err.println(e.toString());
       }
   }
 
   public void simpanpelanggan(int paramidpelanggan, String paramnamapelanggan, String paramnomorrekening, 
           String paramnamabank, String paramidpesanan, String paramalamat, String paramtelpon, String paramstatus, int paramjam, int paramtransaksitotal){
       try{
           String SQL = "INSERT INTO pelanggan(idpelanggan, namapelanggan, nomorrekening, namabank, idpesanan, alamat, telpon, status, jam, transaksitotal)"
                   +"VALUES(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidpelanggan);
           perintah.setString(2, paramnamapelanggan);
           perintah.setString(3, paramnomorrekening);
           perintah.setString(4, paramnamabank);
           perintah.setString(5, paramidpesanan);
           perintah.setString(6, paramalamat);
           perintah.setString(7, paramtelpon);
           perintah.setString(8, paramstatus);
           perintah.setInt(9, paramjam);
           perintah.setInt(10, paramtransaksitotal);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
   } 
   
   public void ubahpelanggan(int paramidpelanggan, String paramnamapelanggan, String paramnomorrekening, 
           String paramnamabank, String paramidpesanan, String paramalamat, String paramtelpon, String paramstatus, int paramjam, int paramtransaksitotal){
       try{
           String SQL = "UPDATE pelanggan SET namapelanggan=?, nomorrekening=?, namabank=?, idpesanan=?,"
                   + "alamat=?, telpon=?, status=?, jam=?, transaksitotal=? WHERE idpelanggan=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1, paramnamapelanggan);
           perintah.setString(2, paramnomorrekening);
           perintah.setString(3, paramnamabank);
           perintah.setString(4, paramidpesanan);
           perintah.setString(5, paramalamat);
           perintah.setString(6, paramtelpon);
           perintah.setString(7, paramstatus);
           perintah.setInt(8, paramjam);
           perintah.setInt(9, paramtransaksitotal);
           perintah.setInt(10, paramidpelanggan);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
}
   public void hapuspelanggan(int paramidpelanggan){
       try{
           String SQL ="DELETE FROM pelanggan WHERE idpelanggan=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidpelanggan);
           perintah.executeUpdate();
           System.out.println("Data Berhasil dihapus");
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   }
   
   public void caripelanggan(int paramidpelanggan){
       try{
           String SQL="SELECT*FROM pelanggan WHERE idpelanggan=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,paramidpelanggan);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("idpelanggan :"+data.getInt("idpelanggan"));
               System.out.println("namapelanggan :"+data.getString("namapelanggan"));
               System.out.println("nomorrekening :"+data.getString("nomorrekening"));
               System.out.println("idpesanan :"+data.getString("idpesanan"));
               System.out.println("alamat :"+data.getString("alamat"));
               System.out.println("telpon :"+data.getString("telpon"));
               System.out.println("status :"+data.getString("status"));
               System.out.println("jam :"+data.getInt("jam"));
               System.out.println("transaksitotal :"+data.getInt("transaksitotal"));
               
           }
       }catch(Exception e){
           System.err.println(e.getMessage());
       }
   }
   
   public void datapelanggan(){
       try{
           Statement stmt = koneksiDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM pelanggan ORDER BY idpelanggan");
           while(baris.next()){
               System.out.println(baris.getInt("idpelanggan")+" | "+
                       baris.getString("namapelanggan")+" | "+
                        baris.getString("nomorrekening")+"|"+
                        baris.getString("namabank")+"|"+
                        baris.getString("idpesanan")+"|"+
                        baris.getString("alamat")+"|"+
                        baris.getString("telpon")+"|"+
                        baris.getString("status")+"|"+
                        baris.getInt("jam"));
           }
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   }
   
    public void simpanfotografer(int paramidfotografer, String paramalamat_lengkap, int paramnomor_hp,String parammediasosial, String paramemail){
       try{
           String SQL = "INSERT INTO fotografer(idfotografer, alamat_lengkap, nomor_hp, mediasosial, email)"
                   +"VALUES(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidfotografer);
           perintah.setString(2, paramalamat_lengkap);
           perintah.setInt(3, paramnomor_hp);
           perintah.setString(4, parammediasosial);
           perintah.setString(5, paramemail);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
   } 
    
    public void ubahfotografer(int paramidfotografer, String paramalamat_lengkap, int paramnomor_hp,String parammediasosial, String paramemail){
       try{
           String SQL = "UPDATE fotografer SET alamat_lengkap=?, nomor_hp=?, mediasosial=?, email=?,"
                   + "WHERE idfotografer=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setString(1, paramalamat_lengkap);
           perintah.setInt(2, paramnomor_hp);
           perintah.setString(3, parammediasosial);
           perintah.setString(4, paramemail);
           perintah.setInt(5, paramidfotografer);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    
    public void hapusfotografer(int paramidfotografer){
       try{
           String SQL ="DELETE FROM fotografer WHERE idfotografer=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramidfotografer);
           perintah.executeUpdate();
           System.out.println("Data Berhasil dihapus");
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   }

       public void carifotografer(int paramidfotografer){
       try{
           String SQL="SELECT*FROM pelanggan WHERE idfotografer=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,paramidfotografer);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("idfotografer :"+data.getInt("idfotografer"));
               System.out.println("alamat_lengkap :"+data.getString("alamat_lengkap"));
               System.out.println("nomor_hp :"+data.getString("nomor_hp"));
               System.out.println("mediasosial :"+data.getInt("mediasosial"));
               System.out.println("email :"+data.getString("email"));     
           }
       }catch(Exception e){
           System.err.println(e.getMessage());
       }
   }
       
    public void datafotografer(){
       try{
           Statement stmt = koneksiDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM fotografer ORDER BY idfotografer");
           while(baris.next()){
               System.out.println(baris.getInt("idfotografer")+" | "+
                       baris.getString("alamat_lengkap")+" | "+
                        baris.getInt("nomor_hp")+"|"+
                        baris.getString("mediasosial")+"|"+
                        baris.getString("email"));
           }
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   }  
    
    public void simpanpesan(int paramid_pemesanan, int paramid_paket, String paramtglpesan, int paramjam){
       try{
           String SQL = "INSERT INTO pesan(id_pemesanan, id_paket, tglpesan, jam)"
                   +"VALUES(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramid_pemesanan);
           perintah.setInt(2, paramid_paket);
           perintah.setString(3, paramtglpesan);
           perintah.setInt(4, paramjam);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
   } 
    
     public void ubahpesan(int paramid_pemesanan, int paramid_paket, String paramtglpesan, int paramjam){
       try{
           String SQL = "UPDATE pesan SET id_paket=?, tglpesan=?, jam=?,"
                   + "WHERE id_pemesanan=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramid_paket);
           perintah.setString(2, paramtglpesan);
           perintah.setInt(3, paramjam);
           perintah.setInt(4, paramid_pemesanan);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
     
     public void hapuspesan(int paramid_pemesanan){
       try{
           String SQL ="DELETE FROM pesan WHERE id_pemesanan=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramid_pemesanan);
           perintah.executeUpdate();
           System.out.println("Data Berhasil dihapus");
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   }
     
    public void caripesan(int paramid_pemesanan){
       try{
           String SQL="SELECT*FROM pesan WHERE id_pemesanan=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,paramid_pemesanan);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("id_pemesanan :"+data.getInt("id_pemesanan"));
               System.out.println("id_paket :"+data.getInt("id_paket"));
               System.out.println("tglpesan :"+data.getString("tglpesan"));
               System.out.println("jam :"+data.getInt("jam"));     
           }
       }catch(Exception e){
           System.err.println(e.getMessage());
       }
   } 
    
   public void datapesan(){
       try{
           Statement stmt = koneksiDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM pesan ORDER BY id_pemesanan");
           while(baris.next()){
               System.out.println(baris.getInt("id_pemesanan")+" | "+
                       baris.getInt("id_paket")+" | "+
                        baris.getString("tglpesan")+"|"+
                        baris.getInt("jam"));
           }
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   } 
   
    public void simpansaran(int paramid_saran, int paramid_pelanggan, String paramsaran){
       try{
           String SQL = "INSERT INTO pesan(id_saran, id_pelanggan, saran)"
                   +"VALUES(?,?,?,?,?,?,?,?,?,?)";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramid_saran);
           perintah.setInt(2, paramid_pelanggan);
           perintah.setString(3, paramsaran);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
   } 

    public void ubahsaran(int paramid_saran, int paramid_pelanggan, String paramsaran){
       try{
           String SQL = "UPDATE saran SET id_pelanggan=?, saran=?,"
                   + "WHERE id_saran=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramid_pelanggan);
           perintah.setString(2, paramsaran);
           perintah.setInt(3, paramid_saran);
           perintah.executeUpdate();
                System.out.println("Data Berhasil disimpan");
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
    
    public void hapussaran(int paramid_saran){
       try{
           String SQL ="DELETE FROM saran WHERE id_saran=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1, paramid_saran);
           perintah.executeUpdate();
           System.out.println("Data Berhasil dihapus");
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   }
    
       public void carisaran(int paramid_saran){
       try{
           String SQL="SELECT*FROM saran WHERE id_saran=?";
           PreparedStatement perintah = koneksiDB.prepareStatement(SQL);
           perintah.setInt(1,paramid_saran);
           ResultSet data = perintah.executeQuery();
           while(data.next()){
               System.out.println("id_saran :"+data.getInt("id_saran"));
               System.out.println("id_pelanggan :"+data.getInt("id_pelanggan"));
               System.out.println("saran :"+data.getString("saran"));    
           }
       }catch(Exception e){
           System.err.println(e.getMessage());
       }
   }
       
       public void datasaran(){
       try{
           Statement stmt = koneksiDB.createStatement();
           ResultSet baris = stmt.executeQuery("SELECT*FROM saran ORDER BY id_saran");
           while(baris.next()){
               System.out.println(baris.getInt("id_saran")+" | "+
                       baris.getInt("id_pelanggan")+" | "+
                        baris.getString("saran"));
           }
       }catch (Exception e){
           System.err.println(e.getMessage());
       }
   } 
}



  

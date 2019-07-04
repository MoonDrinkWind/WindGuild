package china.moondrinkwind.minecraft.team.windguild.database;

/**
 * @Author
 * @Description All sql will save in this class
 * */
public enum SqlManager {
    createGuildTable("createGuildTable","create table Guild(Name CHAR(25) NOT NULL,Owner CHAR(25) NOT NULL,Prefix CHAR(25) NOT NULL)"),
    createPlayerTable("createPlayerTable","create table Guild_Player(Name CHAR(25)NOT NULL,BelongGuild CHAR(25))"),
    getGuild("getGuild","select Name,Owner,Prefix from Guild where Name = ?"),
    getBelongGuild("getBelong","select BelongGuild from Guild_Player where Name = ?"),
    deleteGuild("deleteGuild","delete Guild where Name = ?"),
    updateGuild("updateGuild","update Guild set Owner = ? , Prefix = ?"),
    insertGuild("insertGuild","insert Guild values(?,?,?)"),
    insertPlayer("insertPlayer","insert Guild_Player values(?,?)");

    private String name;
    private String sql;

    SqlManager(String name,String sql){
        this.name = name;
        this.sql = sql;
    }

    public static String getSql(String name){
        for(SqlManager sqlManager:SqlManager.values()){
            if(sqlManager.name.equalsIgnoreCase(name)){
                return sqlManager.sql;
            }
        }
        return null;
    }
}

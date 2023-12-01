package aa.bb.corrcc1kotlin_2023_2024

import java.util.ArrayList

fun getSemestre(mois : Int):Int =
    when(mois)
    {
        in 1..6 ->1
        else ->2

    }

fun getSemestre2(mois : Int):Int =
    when
    {
        mois in 1..6 ->1
        else ->2
    }

fun getSemestre3(mois : Int):Int {
    when
    {
        mois in 1..6 -> return 1
        else ->return  2
    }
}

enum class Region{
    NORD, SUD, OUEST,EST
}

enum class Region2(val code:Int){
    Nord(1), Sud(2), Ouest(3),Est(4)
}

//val tempFar:(Double)->Double={tc:Double->tc*9.0/5+32}

val tempFar={tc:Double->tc*9.0/5+32}
/*
fun tempFar(tc:Double)=tc*9.0/5+32

fun tempFar2(tc:Double):Double{
    return tc*9.0/5+32
}
*/

class Station (var code:Int, var region:Region)
{
    override fun toString()= "$code/$region"
}
/*
class  Station2()
{
    var code:Int
    lateinit var region:Region
    init{
        code=-1
    }


}*/

class Mesure(mois:Int, var temp:Double)
{
    lateinit  var statMesure:Station
    var mois:Int=mois
        set(value)
        {
            if (value in 1..12)
                field=value
            else
                throw Exception("Mois entre 1 et 12")
        }
    constructor(mois:Int,temp:Double,station:Station):this(mois,temp)
    {
        this.statMesure=station
    }

    override fun toString() = "St$statMesure : mois$mois ($temp°C)"


}

var lstMesure:ArrayList<Mesure> =arrayListOf<Mesure>()
fun main()
{

    val m1=Mesure(1,31.0, Station(100,Region.EST))
    val st1=Station(200,Region.OUEST)
    val st2=Station(300,Region.SUD)
    val m2=Mesure(12,25.0,st1)
    val m3=Mesure(12,30.0)
    m3.statMesure=st2
    lstMesure.add(m1)
    lstMesure.add(m2)
    lstMesure.add(m3)
    fun Mesure.semestre()=getSemestre(this.mois)

    val mesureAvecMaxTemp =lstMesure.maxBy { it.temp }
    val codeM=mesureAvecMaxTemp.statMesure.code
    var tempM=mesureAvecMaxTemp.temp
    var tempMFar= tempFar(tempM)
    var regionM=mesureAvecMaxTemp.statMesure.region
    val semestreM = mesureAvecMaxTemp.semestre()
    println("La plus haute température est :${tempM} C° ((${tempMFar}F))")
    println("Code de station ayant connu cette température:${codeM}")
    println("à la région  :${regionM}")
    println("pendant le semestre :${semestreM}")

    //ou
    // println("Code de station ayant connu la plus haute température:
    // ${(lstMesure.maxBy { it.temp }).statMesure.code}")

    val lstMesureM12=lstMesure.filter { it.mois==12 }
    val mesureAvecMax12Temp =lstMesureM12.maxBy { it.temp }
    var tempM12=mesureAvecMax12Temp.temp
    var regionM12=mesureAvecMax12Temp.statMesure.region
    val codeM12=mesureAvecMax12Temp.statMesure.code
    val semestreM12 = mesureAvecMax12Temp.semestre()

    println("La plus haute température est :${tempM12}")
    println("Code de station ayant connu cette température:${codeM12}")
    println("à la région  :${regionM12}")
    println("pendant le semestre :${semestreM12}")

//ou
   // println("Code de station ayant connu la plus haute température:
// ${((lstMesure.filter { it.mois==12 }).maxBy { it.temp }).statMesure.code}")
}






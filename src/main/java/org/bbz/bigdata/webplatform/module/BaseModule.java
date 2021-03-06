package org.bbz.bigdata.webplatform.module;

import org.bbz.bigdata.webplatform.consts.ErrorCode;
import org.nutz.lang.util.NutMap;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by liulaoye on 16-10-31.
 * 所有Module的父类，集中处理一些通用逻辑
 */
public class BaseModule{

    /**
     * 根据错误id，构建相应的错误提示信息
     *
     * @param response　 response
     * @param errId　    错误ｉｄ
     * @return
     *          json
     */
    protected NutMap buildErrorResponse( HttpServletResponse response, ErrorCode errId ){

        return this.buildErrorResponse( response, errId, "" );
    }

    /**
     * 统一处理错误情况
     * @param response  response
     * @param errId     错误ｉｄ
     * @param args      错误的相关参数
     * @return
     *          json
     */
    protected NutMap buildErrorResponse( HttpServletResponse response, ErrorCode errId, String args ){
        response.setStatus( 500 );
        NutMap re = new NutMap();
        re.addv( "errId", errId.toNum() ).addv( "args", args );
//        return "{\"errId\":" + errId.toNum() + ",\"args\":\"" + args + "\"}";
        return re;
    }

    /**
     * 在没有返回值的情况下，统一返回{"success":true}
     * @return
     *          json
     */
    protected NutMap buildSuccessResponse(){
        return new NutMap().addv( "success",true );
    }


    public static void main( String[] args ){
        int lostNumber = 94549;
        int maxNumber = 100000000;

        int[] array = new int[maxNumber-1];
        int index = 0;
        for( int i = 1; i <= maxNumber; i++ ) {
            if( lostNumber != i ) {
                array[index++] = i ;
            }
        }

//        System.out.println( Arrays.toString(array));

        int result = 0;
        for( int i : array ) {
            result ^= i;
        }
        result ^=1;
        result ^=maxNumber;

        System.out.println(result%2==0?result+1:result-1);
    }
}

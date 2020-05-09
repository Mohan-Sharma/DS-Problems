package org.msharma;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public void test()
    {

    }
    public static void main( String[] args )
    {
        /*App app = new App();
        int[] ore = {37, 41, 43, 13,5,11,29,23,2,17,47,7,3,19,31};
        int[] in = {13,5,43,11,41,2, 23,17,29,47,37,3, 7,31,19};
        app.printPostOrder(in, ore, 15);*/
        Set<String> a = Sets.newHashSet("staff", "registered", "Loyalty");
        Set<String> b = Sets.newHashSet("registered", "Loyalty", "staff");
        System.out.println(a.hashCode() == b.hashCode());
    }

    int search(int arr[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }

    public void printPostOrder(int[] in, int[] pre, int n) {
        int root = search(in, pre[0], n);
        if(root != 0)
            printPostOrder(in, Arrays.copyOfRange(pre, 1, pre.length), root);
        if(root != n - 1)
            printPostOrder(Arrays.copyOfRange(in, root + 1, in.length), Arrays.copyOfRange(pre, root + 1, pre.length), n - root - 1);
        System.out.print(pre[0] + " ");
    }


}

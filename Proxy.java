import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

class Proxy {

    interface DataLoader {
        List<Double> loadData(String key);
    }

    static class RemoteDataLoader implements DataLoader {
        @Override
        public List<Double> loadData(String key) {
            //Assume it does a remote call 
            return List.of(new Random().nextDouble());
        }
    }

    static class CachingDataLoader implements DataLoader {
        private final DataLoader remoteDataLoader;
        private final Map<String, List<Double>> cache;

        public CachingDataLoader(DataLoader remoteDataLoader) {
            this.remoteDataLoader = remoteDataLoader;
            this.cache = new ConcurrentHashMap<>();
        }

        @Override
        public List<Double> loadData(String key) {
            return cache.computeIfAbsent(key, remoteDataLoader::loadData);
        }
    }

    static class MetricsDataLoader implements DataLoader {
        private final DataLoader remoteDataLoader;

        MetricsDataLoader(DataLoader remoteDataLoader) {
            this.remoteDataLoader = remoteDataLoader;
        }

        @Override
        public List<Double> loadData(String key) {
            long tick = System.nanoTime();
            List<Double> result = remoteDataLoader.loadData(key);
            long toc = System.nanoTime();
            System.out.println("Time taken = " + (toc - tick) + " ns");
            return result;
        }
    }

    public static void main(String[] args) {
        DataLoader remoteDataLoader = new RemoteDataLoader();
        DataLoader cachingDataLoader = new CachingDataLoader(remoteDataLoader);
        DataLoader metrics = new MetricsDataLoader(remoteDataLoader);

        System.out.println(cachingDataLoader.loadData("a"));
        System.out.println(cachingDataLoader.loadData("a"));
        System.out.println(metrics.loadData("a"));
    }

}
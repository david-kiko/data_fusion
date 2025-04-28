# 如果需要初始化或者升级数据库结构，需要指定profile为schema
docker-compose --profile schema up -d

# 启动dolphinscheduler所有服务，指定profile为all
docker-compose --profile all up -d

docker-compose --profile all up -d --no-deps data_fusion_app
docker-compose --profile all up -d --no-deps sftp
docker-compose --profile all up -d --no-deps dolphinscheduler-worker

# woker容器
# mkdir -p /opt/soft/python/bin
# ln -s /usr/bin/python3 /opt/soft/python/bin/python2.7

export PYTHON_LAUNCHER=/usr/bin/python3
export DATAX_LAUNCHER=/opt/soft/datax/bin/datax.py

apt-get install openjdk-8-jdk
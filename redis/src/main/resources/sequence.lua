-- 检查序列是否存在，如果不存在则初始化为1
local currentValue = redis.call('GET', KEYS[1])
if not currentValue then
    redis.call('SET', KEYS[1], 1)
    return 1
end

-- 获取最大值参数
local maxValue = tonumber(ARGV[1])

-- 自增序列值
local incrementedValue = redis.call('INCR', KEYS[1])

-- 如果自增后的值超过最大值，则重新从1开始
if incrementedValue > maxValue then
    redis.call('SET', KEYS[1], 1)
    incrementedValue = 1
end

return incrementedValue
